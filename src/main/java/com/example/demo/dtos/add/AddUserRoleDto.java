package com.example.demo.dtos.add;

import com.example.demo.models.enums.Role;
import jakarta.validation.constraints.NotNull;

public class AddUserRoleDto {
    private Role role;

    @NotNull(message = "")
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
