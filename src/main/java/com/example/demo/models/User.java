package com.example.demo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends Base {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageURL;

    @Column(name = "username")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
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
    public void setActive(boolean active) {
        isActive = active;
    }

    @Column(name = "image_url")
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public User(String username, String password, String firstName, String lastName, boolean isActive, String imageURL, UserRole role, Set<Offer> offers) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
        this.role = role;
        this.offers = offers;
    }
    public User() {}

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private UserRole role;
    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller", cascade = CascadeType.REMOVE)
    private Set<Offer> offers = new HashSet<>();
    public Set<Offer> getOffers() {
        return offers;
    }
    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return String.format("User with id = %s,\n username = %s,\n password = %s,\n firstName = %s,\n lastName = %s",
                id, username, password, firstName, lastName);
    }
}
