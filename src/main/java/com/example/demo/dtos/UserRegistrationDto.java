package com.example.demo.dtos;

import com.example.demo.utils.validation.UniqueUserName;
import jakarta.validation.constraints.*;

public class UserRegistrationDto {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;


    @UniqueUserName
    @NotEmpty(message = "Username cannot be null or empty!")
    @Size(min = 3, max = 25)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
}
