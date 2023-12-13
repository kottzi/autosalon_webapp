package com.example.demo.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageURL;
    private UserRole role;
    private List<Offer> offers;

    @Column(name = "username", unique = true, nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", unique = true, nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "is_active")
    public boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Column(name = "image_url")
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public User(String username, String password, String firstName, String lastName, boolean isActive, String imageURL, UserRole role, List<Offer> offers) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
        this.role = role;
        this.offers = offers;
    }

    public User(String username, String password, String firstName, String lastName, boolean isActive) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
    }

    public User() {}

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    public List<Offer> getOffers() {
        return offers;
    }
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
