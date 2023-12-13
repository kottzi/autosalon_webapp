package com.example.demo.dtos;

import com.example.demo.models.enums.Role;

import java.util.UUID;

public class UserRoleDto {
    private UUID id;
    private Role role;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserRoleDto(UUID id, Role role) {
        this.id = id;
        this.role = role;
    }
    public UserRoleDto(Role role) {
        this.role = role;
    }
    public UserRoleDto() {}
}
