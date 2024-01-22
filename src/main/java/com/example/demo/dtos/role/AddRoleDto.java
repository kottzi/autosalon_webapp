package com.example.demo.dtos.role;

import com.example.demo.dtos.user.UserDto;
import com.example.demo.models.enums.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class AddRoleDto {
    private UserRole userRole;
    private LocalDate created;

    @Getter @Setter
    private List<UserDto> users;


    @NotNull(message = "Роль должна быть выбрана!")
    public UserRole getUserRole() {
        return userRole;
    }
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public LocalDate getCreated() {
        return created;
    }
    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
