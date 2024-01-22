package com.example.demo.dtos.role;

import com.example.demo.dtos.user.UserDto;
import com.example.demo.models.enums.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class UpdateRoleDto {
    @Getter @Setter
    private UUID id;
    private UserRole userRole;
    private LocalDate modified;

    @Getter @Setter
    private List<UserDto> users;


    @NotNull(message = "Роль должна быть выбрана!")
    public UserRole getUserRole() {
        return userRole;
    }
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public LocalDate getModified() {
        return modified;
    }
    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}
