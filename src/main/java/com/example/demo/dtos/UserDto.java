package com.example.demo.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class UserDto implements Serializable {
    private UUID id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageURL;
    private LocalDate created;
    private LocalDate modified;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
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

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

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

    public UserRoleDto getRole() {
        return role;
    }
    public void setRole(UserRoleDto role) {
        this.role = role;
    }

    private UserRoleDto role;

    public UserDto(UUID id, String username, String password, String firstName, String lastName, boolean isActive, String imageURL, LocalDate created, LocalDate modified, UserRoleDto role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
        this.created = created;
        this.modified = modified;
        this.role = role;
    }

    public UserDto(String username, String password, String firstName, String lastName, boolean isActive, String imageURL, LocalDate created, LocalDate modified, UserRoleDto role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
        this.created = created;
        this.modified = modified;
        this.role = role;
    }

    public UserDto() {}
}
