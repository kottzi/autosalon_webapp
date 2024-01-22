package com.example.demo.dtos.user;

import com.example.demo.dtos.offer.OfferDto;
import com.example.demo.dtos.role.RoleDto;
import com.example.demo.utils.validation.UniqueUserName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class UpdateUserDto {
    @Getter @Setter
    private UUID id;
    private String username;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageURL;
    private LocalDate modified;

    @Getter @Setter
    private RoleDto role;
    @Getter @Setter
    private List<OfferDto> offers;


    @UniqueUserName
    @NotEmpty(message = "Username cannot be null or empty!")
    @Size(min = 5, max = 25)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty(message = "Password cannot be null or empty!")
    @Size(min = 6, max = 18)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty(message = "Confirm Password cannot be null or empty!")
    @Size(min = 6, max = 18)
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @NotEmpty(message = "First name cannot be null or empty!")
    @Size(min = 2, message = "First name should be at least 2 characters long!")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty(message = "Last name cannot be null or empty!")
    @Size(min = 2, message = "Last name should be at least 2 characters long!")
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

    @NotEmpty(message = "ImageURL cannot be null or empty!")
    @Size(min = 5)
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public LocalDate getModified() {
        return modified;
    }
    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}
