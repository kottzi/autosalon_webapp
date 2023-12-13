package com.example.demo.services;

import com.example.demo.dtos.UserRoleDto;
import com.example.demo.dtos.add.AddUserRoleDto;

import java.util.List;
import java.util.UUID;

public interface UserRoleService {
    void createUserRole(UserRoleDto userRoleDto);

    void addUserRole(AddUserRoleDto userRoleDto);
    void deleteUserRole(UserRoleDto userRoleDto);
    void deleteUserRoleById(UUID id);

    List<UserRoleDto> findAllUserRoles();
    UserRoleDto findUserRoleById(UUID id);
}
