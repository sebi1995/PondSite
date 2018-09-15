package com.sebastian.PondSite.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "user_ponds",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "pond_id")}
    )
    private List<Pond> owner_ponds;

    public User() {

    }

    public User(String username, String password, List<Pond> owner_ponds) {
        this.username = username;
        this.password = password;
        this.owner_ponds = owner_ponds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Pond> getOwner_ponds() {
        return owner_ponds;
    }

    public void setOwner_ponds(List<Pond> owner_ponds) {
        this.owner_ponds = owner_ponds;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", owner_ponds=" + owner_ponds +
                '}';
    }
}
