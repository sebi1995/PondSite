package com.sebastian.PondSite.entities;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "POND")
public class Pond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String pond_name;

    @Column
    private int pond_visits;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "POND_IMAGE",
            joinColumns = { @JoinColumn(name = "pond_id") },
            inverseJoinColumns = { @JoinColumn(name = "image_id") }
    )
    private List<Image> pond_images;

    public Pond() {

    }

    public Pond(String pond_name, int pond_visits, List<Image> pond_images) {
        this.pond_name = pond_name;
        this.pond_visits = pond_visits;
        this.pond_images = pond_images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPond_name() {
        return pond_name;
    }

    public void setPond_name(String pond_name) {
        this.pond_name = pond_name;
    }

    public int getPond_visits() {
        return pond_visits;
    }

    public void setPond_visits(int pond_visits) {
        this.pond_visits = pond_visits;
    }

    public List<Image> getPond_images() {
        return pond_images;
    }

    public void setPond_images(List<Image> pond_images) {
        this.pond_images = pond_images;
    }
}
