package com.sebastian.PondSite.entities;

import javax.persistence.*;

@Entity
public class SiteUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String updateText;

    @Column
    private String date;

    @Column
    private Integer isHidden;

    public SiteUpdate() {

    }

    public SiteUpdate(String updateText, String date, Integer isHidden) {
        this.updateText = updateText;
        this.date = date;
        this.isHidden = isHidden;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUpdateText() {
        return updateText;
    }

    public void setUpdateText(String updateText) {
        this.updateText = updateText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
    }
}
