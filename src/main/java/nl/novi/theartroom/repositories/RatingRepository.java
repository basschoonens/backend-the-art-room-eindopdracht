package nl.novi.theartroom.repositories;

import nl.novi.theartroom.models.Rating;
import nl.novi.theartroom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByArtworkId(Long artworkId);
    Optional<Rating> findByIdAndArtworkId(Long ratingId, Long artworkId);
    Optional<Rating> findByUserUsernameAndArtworkId(String username, Long artworkId);

}