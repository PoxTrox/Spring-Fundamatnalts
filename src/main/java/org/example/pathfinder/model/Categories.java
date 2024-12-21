package org.example.pathfinder.model;

import jakarta.persistence.*;
import org.example.pathfinder.enums.CategoryType;

@Entity
@Table (name = "categories")
public class Categories {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    // name - Accepts String values (PEDESTRIAN, BICYCLE, MOTORCYCLE, CAR)
    //
    //· description - Accepts very long String value

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryType name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Categories() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoryType getName() {
        return name;
    }

    public void setName(CategoryType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
