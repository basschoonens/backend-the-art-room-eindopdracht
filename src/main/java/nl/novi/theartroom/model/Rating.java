package nl.novi.theartroom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import nl.novi.theartroom.model.artworks.Artwork;
import nl.novi.theartroom.model.users.User;

@Entity
@Table(name = "ratings",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_username", "artwork_id"})
)
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_id_seq")
    @SequenceGenerator(name = "rating_id_seq", sequenceName = "rating_id_seq", initialValue = 2000, allocationSize = 1)
    private Long ratingId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artwork_id")
    @JsonIgnore
    Artwork artwork;

    @ManyToOne
    @JoinColumn(name = "user_username")
    private User user;

    @Min(1)
    @Max(5)
    private int rating;

    private String comment;

    public Rating() {
    }

    public Rating(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long id) {
        this.ratingId = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String commentText) {
        this.comment = commentText;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
