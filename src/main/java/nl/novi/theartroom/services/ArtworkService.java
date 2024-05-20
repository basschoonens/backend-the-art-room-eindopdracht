package nl.novi.theartroom.services;

import jakarta.transaction.Transactional;
import nl.novi.theartroom.dtos.artworkdtos.ArtworkOutputArtloverDto;
import nl.novi.theartroom.dtos.artworkdtos.ArtworkInputDto;
import nl.novi.theartroom.exceptions.RecordNotFoundException;
import nl.novi.theartroom.mappers.ArtworkArtloverDtoMapper;
import nl.novi.theartroom.mappers.ArtworkInputDtoMapper;
import nl.novi.theartroom.models.Artwork;
import nl.novi.theartroom.models.ArtworkImage;
import nl.novi.theartroom.models.User;
import nl.novi.theartroom.repositories.ArtworkRepository;
import nl.novi.theartroom.repositories.FileUploadRepository;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtworkService {

    private final ArtworkRepository artworkRepository;
    private final RatingService ratingService;
    private final FileUploadRepository uploadRepository;
    private final ArtworkImageService photoService;
    private final UserService userService;

    public ArtworkService(ArtworkRepository artworkRepository, RatingService ratingService, FileUploadRepository uploadRepository, ArtworkImageService photoService, UserService userService) {
        this.artworkRepository = artworkRepository;
        this.ratingService = ratingService;
        this.uploadRepository = uploadRepository;
        this.photoService = photoService;
        this.userService = userService;
    }

    // TODO Add the total amount of ratings to the artwork
    // TODO Separate the calculation of the average rating to a separate class

    public List<ArtworkOutputArtloverDto> getAllArtworks() {
        List<Artwork> artworks = artworkRepository.findAll();
        List<ArtworkOutputArtloverDto> artworkDtos = new ArrayList<>();

        for (Artwork artwork : artworks) {
            ArtworkOutputArtloverDto dto = ArtworkArtloverDtoMapper.toArtworkArtloverDto(artwork);
            double averageRating = ratingService.calculateAverageRatingForArtwork(artwork.getId());
            dto.setAverageRating(averageRating);
            artworkDtos.add(dto);
        }

        return artworkDtos;
    }

    public ArtworkOutputArtloverDto getArtworkById(Long id) {
        Optional<Artwork> optionalArtwork = artworkRepository.findById(id);
        if (optionalArtwork.isEmpty()) {
            throw new RecordNotFoundException("Artwork with id " + id + " not found.");
        } else {
            Artwork artwork = optionalArtwork.get();
            double averageRating = ratingService.calculateAverageRatingForArtwork(id);
            ArtworkOutputArtloverDto dto = ArtworkArtloverDtoMapper.toArtworkArtloverDto(artwork);
            dto.setAverageRating(averageRating);

            return dto;
        }
    }

//    public void saveArtwork(ArtworkInputDto dto) {
//        Artwork Artwork = ArtworkInputDtoMapper.toArtwork(dto);
//        artworkRepository.save(Artwork);
//    }

    // save artwork + return URI location
    public Long saveArtwork(ArtworkInputDto dto) {
        Artwork artwork = ArtworkInputDtoMapper.toArtwork(dto);
        Artwork savedArtwork = artworkRepository.save(artwork);
        return savedArtwork.getId(); // Assuming getId() returns the ID of the artwork
    }

    // Save artwork for Artist
    public Long saveArtworkForArtist(ArtworkInputDto dto, String username) {
        Artwork artwork = ArtworkInputDtoMapper.toArtwork(dto);
        User user = userService.getUserByUsername(username);
        artwork.setUser(user); // Set the User object on the Artwork
        Artwork savedArtwork = artworkRepository.save(artwork);
        return savedArtwork.getId(); // Assuming getId() returns the ID of the artwork
    }

    public List<ArtworkOutputArtloverDto> getArtworksByUser(String username) {
        User user = userService.getUserByUsername(username);
        List<Artwork> artworks = artworkRepository.findAllByUser(user);
        return artworks.stream()
                .map(ArtworkArtloverDtoMapper::toArtworkArtloverDto)
                .collect(Collectors.toList());
    }

    public void updateArtwork(Long id, ArtworkInputDto dto) {
        Optional<Artwork> artworkFound = artworkRepository.findById(id);
        if (artworkFound.isEmpty()) {
            throw new RecordNotFoundException("Artwork with id " + id + " not found.");
        } else {
            artworkRepository.save(ArtworkInputDtoMapper.toArtwork(dto, artworkFound.get()));
        }
    }

    public void deleteArtwork(Long id) {
        Optional<Artwork> artworkFound = artworkRepository.findById(id);
        if (artworkFound.isEmpty()) {
            throw new RecordNotFoundException("Artwork with id " + id + " not found.");
        } else {
            artworkRepository.delete(artworkFound.get());
        }
    }

    // Image methods

    @Transactional
    public Resource getImageFromArtwork(Long artworkId){
        Optional<Artwork> optionalArtwork = artworkRepository.findById(artworkId);
        if(optionalArtwork.isEmpty()){
            throw new RecordNotFoundException("Artwork with artwork number " + artworkId + " not found.");
        }
        ArtworkImage photo = optionalArtwork.get().getArtworkImage();
        if(photo == null){
            throw new RecordNotFoundException("Artwork " + artworkId + " had no photo.");
        }
        return photoService.downLoadFile(photo.getFileName());
    }

    @Transactional
    public Artwork assignImageToArtwork(String filename, Long artworkId) {
        Optional<Artwork> optionalArtwork = artworkRepository.findById(artworkId);
        Optional<ArtworkImage> optionalPhoto = uploadRepository.findByFileName(filename);

        if (optionalArtwork.isPresent() && optionalPhoto.isPresent()) {
            ArtworkImage photo = optionalPhoto.get();
            Artwork artwork = optionalArtwork.get();
            artwork.setArtworkImage(photo);
            return artworkRepository.save(artwork);
        } else {
            throw new RecordNotFoundException("artwork of foto niet gevonden");
        }
    }


}