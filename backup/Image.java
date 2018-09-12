package com.sebastian.PondSite.entities;

import javax.persistence.*;
import java.util.List;

@Entity()
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String image_content;

    @ManyToMany(mappedBy = "pond_images")
    private List<Pond> ponds;

    public Image() {

    }

    public Image(String image_content, List<Pond> ponds) {
        this.image_content = image_content;
        this.ponds = ponds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_content() {
        return image_content;
    }

    public void setImage_content(String image_content) {
        this.image_content = image_content;
    }

    public List<Pond> getPonds() {
        return ponds;
    }

    public void setPonds(List<Pond> ponds) {
        this.ponds = ponds;
    }

    @Override
    public String toString() {
        return this.image_content;
    }
}
