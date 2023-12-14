package com.example.demo.dtos.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowUserDetailsDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
}
