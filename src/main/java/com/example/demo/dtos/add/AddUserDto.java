package com.example.demo.dtos.add;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AddUserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageURL;
    private LocalDate created;
    private LocalDate modified;

    @NotEmpty(message = "")
    @Size(min = 3, max = 30, message = "")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty(message = "")
    @Size(min = 6, max = 24, message = "")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty(message = "")
    @Size(min = 1, max = 50, message = "")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty(message = "")
    @Size(min = 1, max = 50, message = "")
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

    @NotNull(message = "")
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @NotNull(message = "User's created date must not be null or empty!")
    public LocalDate getCreated() {
        return created;
    }
    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @NotNull(message = "User's modified date must not be null or empty!")
    public LocalDate getModified() {
        return modified;
    }
    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}
