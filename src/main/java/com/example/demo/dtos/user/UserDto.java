package com.example.demo.dtos.user;

import com.example.demo.dtos.offer.OfferDto;
import com.example.demo.dtos.role.RoleDto;
import com.example.demo.models.entities.Role;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class UserDto implements Serializable {
    private UUID id;
    private LocalDate created;
    private LocalDate modified;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageURL;

    private RoleDto role;
    private List<OfferDto> offers;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public List<OfferDto> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferDto> offers) {
        this.offers = offers;
    }


    public UserDto(UUID id, LocalDate created, LocalDate modified, String username, String password, String firstName, String lastName, boolean isActive, String imageURL, RoleDto role, List<OfferDto> offers) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
        this.role = role;
        this.offers = offers;
    }

    public UserDto(LocalDate created, LocalDate modified, String username, String password, String firstName, String lastName, boolean isActive, String imageURL, RoleDto role, List<OfferDto> offers) {
        this.created = created;
        this.modified = modified;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
        this.role = role;
        this.offers = offers;
    }

    public UserDto(String username, String password, String firstName, String lastName, boolean isActive, String imageURL, RoleDto role, List<OfferDto> offers) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
        this.role = role;
        this.offers = offers;
    }

    public UserDto(String username, String password, String firstName, String lastName, boolean isActive, String imageURL) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
    }

    public UserDto() {}
}
