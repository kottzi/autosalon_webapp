package com.example.demo.dtos.all;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowAllUsersDto implements Serializable {
    private String username;
    private String firstName;
    private String lastName;
    private boolean isActive;
}
