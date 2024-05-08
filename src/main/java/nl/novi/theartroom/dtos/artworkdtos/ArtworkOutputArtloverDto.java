package nl.novi.theartroom.dtos.artworkdtos;

import nl.novi.theartroom.dtos.ratingdtos.RatingUserDto;

import java.time.LocalDate;
import java.util.List;

public class ArtworkOutputArtloverDto {

    private Long id;
    private String title;
    private String artist;
    private String description;
    private LocalDate dateCreated;
    private String edition;
    private String imagePath;
    private String artworkType;
    private List<RatingUserDto> ratings;
    private double averageRating;
    private PaintingOutputDto paintingOutputDto;
    private DrawingOutputDto drawingOutputDto;

    public ArtworkOutputArtloverDto() {
    }

    public ArtworkOutputArtloverDto(Long id, String title, String artist, String description, LocalDate dateCreated, String edition, String imagePath, String artworkType, List<RatingUserDto> ratings, double averageRating, byte[] imageData, PaintingOutputDto paintingOutputDto, DrawingOutputDto drawingOutputDto) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.description = description;
        this.dateCreated = dateCreated;
        this.edition = edition;
        this.imagePath = imagePath;
        this.artworkType = artworkType;
        this.ratings = ratings;
        this.averageRating = averageRating;
        this.paintingOutputDto = paintingOutputDto;
        this.drawingOutputDto = drawingOutputDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getArtworkType() {
        return artworkType;
    }

    public void setArtworkType(String artworkType) {
        this.artworkType = artworkType;
    }

    public PaintingOutputDto getPaintingOutputDto() {
        return paintingOutputDto;
    }

    public void setPaintingOutputDto(PaintingOutputDto paintingOutputDto) {
        this.paintingOutputDto = paintingOutputDto;
    }

    public DrawingOutputDto getDrawingOutputDto() {
        return drawingOutputDto;
    }

    public void setDrawingOutputDto(DrawingOutputDto drawingOutputDto) {
        this.drawingOutputDto = drawingOutputDto;
    }

    public List<RatingUserDto> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingUserDto> ratings) {
        this.ratings = ratings;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }


}
