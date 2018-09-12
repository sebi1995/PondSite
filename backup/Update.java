package com.sebastian.PondSite.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Update {

    @Id @GeneratedValue
    private int id;

    @Column
    private String text;

    @Column
    private String updateDate;

    private Update(){

    }

    public Update(String text, String updateDate) {
        this.text = text;
        this.updateDate = updateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
