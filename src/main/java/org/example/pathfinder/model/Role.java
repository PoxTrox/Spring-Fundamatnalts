package org.example.pathfinder.model;

import jakarta.persistence.*;
import org.example.pathfinder.enums.UserRoles;

@Entity
@Table (name = "roles")
public class Role {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated (EnumType.STRING)
    @Column(name = "name")
    private UserRoles name;

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserRoles getName() {
        return name;
    }

    public void setName(UserRoles name) {
        this.name = name;
    }
}
