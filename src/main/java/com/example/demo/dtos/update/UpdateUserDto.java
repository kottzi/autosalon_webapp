package com.example.demo.dtos.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserDto {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
}
