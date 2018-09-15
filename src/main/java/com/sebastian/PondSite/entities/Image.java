package com.sebastian.PondSite.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String imagePath;

    @ManyToMany(mappedBy = "pond_images")
    private List<Pond> ponds;

    public Image() {

    }

    public Image(String imagePath, List<Pond> ponds) {
        this.imagePath = imagePath;
        this.ponds = ponds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Pond> getPonds() {
        return ponds;
    }

    public void setPonds(List<Pond> ponds) {
        this.ponds = ponds;
    }
}
