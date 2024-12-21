package org.example.pathfinder.model;

import jakarta.persistence.*;
import jdk.jfr.Category;
import org.example.pathfinder.enums.Level;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "routes")
public class Route {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (columnDefinition = "TEXT")
    private String description;

    //· gpx coordinates - Accepts very long text values
    @Column(name = "gpx_coordinates",columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Column (nullable = false,unique = true)
    private String name;

    @ManyToOne (optional = false)
    private User author;

    @Enumerated(EnumType.STRING)
    @Column
    private Level level;

    @Column(name = "video_url")
    private String videoUrl;

    @OneToMany (mappedBy = "route")

    private Set<Comment> comments;

    @OneToMany (mappedBy = "route")
    private Set<Picture>pictures;

    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Categories> categories;;

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public Route() {
        this. comments = new HashSet<Comment>();
        this.pictures =new HashSet<>();
        this.categories = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }
}

