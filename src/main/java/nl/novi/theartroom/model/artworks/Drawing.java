package nl.novi.theartroom.model.artworks;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import nl.novi.theartroom.model.Order;
import nl.novi.theartroom.model.Rating;
import nl.novi.theartroom.model.users.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "drawings")
public class Drawing extends Artwork {

    private String drawingSurface;
    private String drawingMaterial;
    private Integer drawingDimensionsWidthInCm;
    private Integer drawingDimensionsHeightInCm;

    public Drawing() {
    }

    public Drawing(String title, String artist, String description, LocalDate dateCreated, Double galleryBuyingPrice, String edition, ArtworkImage artworkImage, String artworkType, List<Rating> ratings, User user, Set<Order> orders, String drawingSurface, String drawingMaterial, Integer drawingDimensionsWidthInCm, Integer drawingDimensionsHeightInCm) {
        super(title, artist, description, dateCreated, galleryBuyingPrice, edition, artworkImage, artworkType, ratings, user, orders);
        this.drawingSurface = drawingSurface;
        this.drawingMaterial = drawingMaterial;
        this.drawingDimensionsWidthInCm = drawingDimensionsWidthInCm;
        this.drawingDimensionsHeightInCm = drawingDimensionsHeightInCm;
    }


    public String getDrawingSurface() {
        return drawingSurface;
    }

    public void setDrawingSurface(String drawingSurface) {
        this.drawingSurface = drawingSurface;
    }

    public String getDrawingMaterial() {
        return drawingMaterial;
    }

    public void setDrawingMaterial(String drawingMaterial) {
        this.drawingMaterial = drawingMaterial;
    }

    public Integer getDrawingDimensionsWidthInCm() {
        return drawingDimensionsWidthInCm;
    }

    public void setDrawingDimensionsWidthInCm(Integer drawingDimensionsWidthInCm) {
        this.drawingDimensionsWidthInCm = drawingDimensionsWidthInCm;
    }

    public Integer getDrawingDimensionsHeightInCm() {
        return drawingDimensionsHeightInCm;
    }

    public void setDrawingDimensionsHeightInCm(Integer drawingDimensionsHeightInCm) {
        this.drawingDimensionsHeightInCm = drawingDimensionsHeightInCm;
    }
}
