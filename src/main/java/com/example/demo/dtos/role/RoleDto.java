package com.example.demo.dtos.role;

import com.example.demo.dtos.user.UserDto;
import com.example.demo.models.enums.UserRole;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class RoleDto implements Serializable {
    private UUID id;
    private LocalDate created;
    private LocalDate modified;

    private UserRole userRole;
    private List<UserDto> users;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }


    public RoleDto(UUID id, LocalDate created, LocalDate modified, UserRole userRole, List<UserDto> users) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.userRole = userRole;
        this.users = users;
    }

    public RoleDto(LocalDate created, LocalDate modified, UserRole userRole, List<UserDto> users) {
        this.created = created;
        this.modified = modified;
        this.userRole = userRole;
        this.users = users;
    }

    public RoleDto(UserRole userRole, List<UserDto> users) {
        this.userRole = userRole;
        this.users = users;
    }

    public RoleDto(UserRole userRole) {
        this.userRole = userRole;
    }

    public RoleDto() {}
}
