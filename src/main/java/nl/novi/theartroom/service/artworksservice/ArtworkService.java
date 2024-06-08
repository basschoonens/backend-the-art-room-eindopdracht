package nl.novi.theartroom.service.artworksservice;

import jakarta.transaction.Transactional;
import nl.novi.theartroom.dto.artworkdto.ArtworkOutputArtistAdminDto;
import nl.novi.theartroom.dto.artworkdto.ArtworkOutputUserDto;
import nl.novi.theartroom.dto.artworkdto.ArtworkInputDto;
import nl.novi.theartroom.exception.*;
import nl.novi.theartroom.mapper.artworkmappers.ArtworkArtistDtoMapper;
import nl.novi.theartroom.mapper.artworkmappers.ArtworkUserDtoMapper;
import nl.novi.theartroom.mapper.artworkmappers.ArtworkInputDtoMapper;
import nl.novi.theartroom.model.artworks.Artwork;
import nl.novi.theartroom.model.artworks.ArtworkImage;
import nl.novi.theartroom.model.users.User;
import nl.novi.theartroom.repository.ArtworkRepository;
import nl.novi.theartroom.repository.FileUploadRepository;
import nl.novi.theartroom.service.userservice.UserService;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtworkService {

    private final ArtworkRepository artworkRepository;
    private final FileUploadRepository uploadRepository;
    private final ArtworkImageService photoService;
    private final UserService userService;
    private final ArtworkInputDtoMapper artworkInputDtoMapper;
    private final ArtworkUserDtoMapper artworkUserDtoMapper;
    private final ArtworkArtistDtoMapper artworkArtistDtoMapper;

    public ArtworkService(ArtworkRepository artworkRepository, FileUploadRepository uploadRepository, ArtworkImageService photoService, UserService userService, ArtworkInputDtoMapper artworkInputDtoMapper, ArtworkUserDtoMapper artworkUserDtoMapper, ArtworkArtistDtoMapper artworkArtistDtoMapper) {
        this.artworkRepository = artworkRepository;
        this.uploadRepository = uploadRepository;
        this.photoService = photoService;
        this.userService = userService;
        this.artworkInputDtoMapper = artworkInputDtoMapper;
        this.artworkUserDtoMapper = artworkUserDtoMapper;
        this.artworkArtistDtoMapper = artworkArtistDtoMapper;
    }

    // UNAUTHENTICATED ARTWORKS METHOD

    public List<ArtworkOutputUserDto> getAllArtworks() {
        List<Artwork> artworks = artworkRepository.findAll();
        return artworks.stream()
                .map(artworkUserDtoMapper::toArtworkUserDto)
                .collect(Collectors.toList());
    }

    public ArtworkOutputUserDto getArtworkById(Long id) {
        Artwork artwork = artworkRepository.findById(id)
                .orElseThrow(() -> new ArtworkNotFoundException("Artwork with id " + id + " not found."));
        return artworkUserDtoMapper.toArtworkUserDto(artwork);
    }

    // ARTIST ARTWORKS METHOD

    public List<ArtworkOutputArtistAdminDto> getArtworksByArtist(String username) {
        User user = userService.getUserByUsername(username);
        List<Artwork> artworks = artworkRepository.findAllByUser(user);

        return artworks.stream()
                .map(artworkArtistDtoMapper::toArtworkArtistDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long createArtworkForArtist(ArtworkInputDto dto, String username) {
        try {
            Artwork artwork = artworkInputDtoMapper.toArtwork(dto);
            User user = userService.getUserByUsername(username);
            artwork.setUser(user);
            Artwork savedArtwork = artworkRepository.save(artwork);
            return savedArtwork.getArtworkId();
        } catch (MappingException e) {
            throw new MappingException("Error mapping artwork to the database", e);
        } catch (DataAccessException e) {
            throw new DatabaseException("Error saving artwork to the database", e);
        }
    }

    @Transactional
    public void updateArtworkForArtist(Long id, ArtworkInputDto dto, String username) {
        try {
            Optional<Artwork> artworkFound = artworkRepository.findById(id);
            if (artworkFound.isEmpty()) {
                throw new ArtworkNotFoundException("Artwork with id " + id + " not found.");
            }
            Artwork existingArtwork = artworkFound.get();
            if (!existingArtwork.getUser().getUsername().equals(username)) {
                throw new UnauthorizedAccessException("User not authorized to update this artwork");
            }
            if (!existingArtwork.getArtworkType().equals(dto.getArtworkType())) {
                throw new InvalidArtworkTypeException("Artwork type cannot be changed.");
            }
            Artwork updatedArtwork = artworkInputDtoMapper.toArtwork(dto, existingArtwork);
            artworkRepository.save(updatedArtwork);
        } catch (MappingException e) {
            throw new MappingException("Error mapping artwork to the database", e);
        } catch (DataAccessException e) {
            throw new DatabaseException("Error saving artwork to the database", e);
        }
    }

    public void deleteArtworkForArtist(Long id) {
        Optional<Artwork> artworkFound = artworkRepository.findById(id);
        if (artworkFound.isEmpty()) {
            throw new ArtworkNotFoundException("Artwork with id " + id + " not found.");
        } else {
            Artwork artwork = artworkFound.get();
            if (artwork.getArtworkImage() != null) {
                uploadRepository.delete(artwork.getArtworkImage());
            }
            artworkRepository.delete(artwork);
        }
    }

    // Image methods

    @Transactional
    public Artwork addOrUpdateImageToArtwork(String filename, Long artworkId) {
        Optional<Artwork> optionalArtwork = artworkRepository.findById(artworkId);
        Optional<ArtworkImage> optionalPhoto = uploadRepository.findByFileName(filename);

        if (optionalArtwork.isPresent() && optionalPhoto.isPresent()) {
            ArtworkImage photo = optionalPhoto.get();
            Artwork artwork = optionalArtwork.get();
            artwork.setArtworkImage(photo);
            return artworkRepository.save(artwork);
        } else {
            throw new RecordNotFoundException("Artwork or Photo not found.");
        }
    }

    @Transactional
    public Resource getImageFromArtwork(Long artworkId) {
        Optional<Artwork> optionalArtwork = artworkRepository.findById(artworkId);
        if (optionalArtwork.isEmpty()) {
            throw new RecordNotFoundException("Artwork with artwork number " + artworkId + " not found.");
        }
        ArtworkImage photo = optionalArtwork.get().getArtworkImage();
        if (photo == null) {
            throw new RecordNotFoundException("Artwork " + artworkId + " had no photo.");
        }
        return photoService.downLoadFile(photo.getFileName());
    }

    // ADMIN ARTWORKS METHOD

    public void updateArtworkForAdmin(Long id, ArtworkInputDto dto) {
        try {
            Optional<Artwork> artworkFound = artworkRepository.findById(id);
            if (artworkFound.isEmpty()) {
                throw new ArtworkNotFoundException("Artwork with id " + id + " not found.");
            }
            Artwork existingArtwork = artworkFound.get();
            Artwork updatedArtwork = artworkInputDtoMapper.toArtwork(dto, existingArtwork);
            artworkRepository.save(updatedArtwork);
        } catch (MappingException e) {
            throw new MappingException("Error mapping artwork to the database", e);
        } catch (DataAccessException e) {
            throw new DatabaseException("Error saving artwork to the database", e);
        }
    }

    public void deleteArtworkForAdmin(Long id) {
        Optional<Artwork> artworkFound = artworkRepository.findById(id);
        if (artworkFound.isEmpty()) {
            throw new ArtworkNotFoundException("Artwork with id " + id + " not found.");
        } else {
            Artwork artwork = artworkFound.get();
            if (artwork.getArtworkImage() != null) {
                uploadRepository.delete(artwork.getArtworkImage());
            }
            artworkRepository.delete(artwork);
        }
    }

}