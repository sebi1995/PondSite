package com.sebastian.PondSite.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String added_date;

    @Column
    private String last_updated;

//    @Column
//    private List<Comment> comments;

//    @Column
//    private List<Rating> ratings;

    @ManyToMany(mappedBy = "owner_ponds")
    private List<User> pond_owner;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "pond_image",
            joinColumns = {@JoinColumn(name = "pond_id")},
            inverseJoinColumns = {@JoinColumn(name = "image_id")}
    )
    private List<Image> pond_images;

    public Pond() {

    }

    public Pond(String name, String added_date, String last_updated, List<User> pond_owner, List<Image> pond_images) {
        this.name = name;
        this.added_date = added_date;
        this.last_updated = last_updated;
        this.pond_owner = pond_owner;
        this.pond_images = pond_images;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdded_date() {
        return added_date;
    }

    public void setAdded_date(String added_date) {
        this.added_date = added_date;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public List<User> getPond_owner() {
        return pond_owner;
    }

    public void setPond_owner(List<User> pond_owner) {
        this.pond_owner = pond_owner;
    }

    public List<Image> getPond_images() {
        return pond_images;
    }

    public void setPond_images(List<Image> pond_images) {
        this.pond_images = pond_images;
    }
}
