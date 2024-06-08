package nl.novi.theartroom.controller;

import nl.novi.theartroom.dto.ratingdto.RatingOutputWithArtworkDto;
import nl.novi.theartroom.dto.ratingdto.RatingUserDto;
import nl.novi.theartroom.model.Rating;
import nl.novi.theartroom.service.RatingService;
import nl.novi.theartroom.service.userservice.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/ratings")
public class RatingController {

    private final RatingService ratingService;

    private final UserService userService;

    public RatingController(RatingService ratingService, UserService userService) {
        this.ratingService = ratingService;
        this.userService = userService;
    }

    // USER RATINGS METHOD

    // Ratings by artwork id method

    @GetMapping("/{artworkId}/ratings")
    public ResponseEntity<List<RatingUserDto>> getAllRatingsForArtwork(@PathVariable Long artworkId) {
        List<RatingUserDto> ratings = ratingService.getAllRatingsForArtwork(artworkId);

        return ResponseEntity.ok(ratings);
    }

    // All ratings done by user with artworkdetails method

    @GetMapping("/user")
    public ResponseEntity<List<RatingOutputWithArtworkDto>> getAllRatingsForArtworksDoneByUser() {
        String username = userService.getCurrentLoggedInUsername();
        List<RatingOutputWithArtworkDto> ratings = ratingService.getAllRatingsByUserWithArtworkDetails(username);
        return ResponseEntity.ok(ratings);
    }

    @PostMapping("/{artworkId}/user")
    public ResponseEntity<Void> addOrUpdateRatingToArtworkByUser(@PathVariable Long artworkId, @RequestBody RatingUserDto ratingUserDto) {
        String username = userService.getCurrentLoggedInUsername();
        RatingOutputWithArtworkDto ratingDto = ratingService.addOrUpdateRatingToArtwork(username, artworkId, ratingUserDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{ratingId}")
                .buildAndExpand(ratingDto.getRatingId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{artworkId}/user")
    public ResponseEntity<Void> deleteRatingToArtworkDoneByUser(@PathVariable Long artworkId) {
        String username = userService.getCurrentLoggedInUsername();
        ratingService.deleteRatingByUsernameAndArtworkId(username, artworkId);
        return ResponseEntity.noContent().build();
    }

    // ARTIST RATING METHODS
    // Artist moet per artwork alle ratings kunnen inzien en/of verwijderen.

    // All ratings for an artist by artwork id method

    @GetMapping("/artist")
    public ResponseEntity<List<RatingOutputWithArtworkDto>> getAllRatingsForArtist() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        List<RatingOutputWithArtworkDto> ratings = ratingService.getAllRatingsForArtist(username);

        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/{artworkId}/ratings/artist")
    public ResponseEntity<List<RatingOutputWithArtworkDto>> getAllRatingsForArtworkWithArtworkDetails(@PathVariable Long artworkId) {
        List<RatingOutputWithArtworkDto> ratings = ratingService.getAllRatingsForArtworkWithArtworkDetails(artworkId);

        return ResponseEntity.ok(ratings);
    }

    @DeleteMapping("/{artworkId}/ratings/{ratingId}")
    public ResponseEntity<Void> deleteRatingByArtistAdmin(@PathVariable Long artworkId, @PathVariable Long ratingId) {
        ratingService.deleteRatingByArtworkIdAndRatingId(artworkId, ratingId);
        return ResponseEntity.noContent().build();
    }

    // ADMIN METHODS
    // All ratings for the admin done by users with artwork details method

    // Met deze methode kan de admin alle ratings inzien
    @GetMapping()
    public ResponseEntity<List<RatingOutputWithArtworkDto>> getAllRatings() {
        List<RatingOutputWithArtworkDto> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

//    Deze heb ik volgens mij niet nodig
//    @GetMapping("/admin")
//    public ResponseEntity<List<RatingOutputWithArtworkDto>> getAllRatingsForAdmin(@PathVariable Long artworkId) {
//        List<RatingOutputWithArtworkDto> ratings = ratingService.getAllRatingsForArtworkWithArtworkDetails(artworkId);
//
//        return ResponseEntity.ok(ratings);
//    }

    // CRUD OPERATIONS FOR RATING

    @GetMapping("/{ratingId}")
    public ResponseEntity<RatingOutputWithArtworkDto> getRatingById(@PathVariable Long ratingId) {
        RatingOutputWithArtworkDto rating = ratingService.getRatingById(ratingId);
        return ResponseEntity.ok(rating);
    }

    @PostMapping()
    public ResponseEntity<Void> addRating(@RequestBody RatingUserDto rating) {
        Rating newRating = ratingService.addRating(rating);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{ratingId}")
                .buildAndExpand(newRating.getRatingId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{ratingId}")
    public ResponseEntity<Void> updateRating(@PathVariable Long ratingId, @RequestBody RatingUserDto rating) {
        ratingService.updateRating(ratingId, rating);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.noContent().build();
    }

}
