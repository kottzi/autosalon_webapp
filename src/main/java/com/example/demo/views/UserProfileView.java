package com.example.demo.views;

import com.example.demo.dtos.role.RoleDto;
import com.example.demo.models.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileView {
    String username;
    String firstName;
    String lastName;
    Role role;
}
