package com.example.demo.services;

import com.example.demo.dtos.role.RoleDto;
import com.example.demo.dtos.role.AddRoleDto;
import com.example.demo.dtos.role.UpdateRoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {
    void addRole(AddRoleDto userRoleDto);

    void deleteRole(RoleDto roleDto);
    void deleteRoleById(UUID id);
    void deleteAllRoles();

    List<RoleDto> findAllRoles();
    RoleDto findRoleById(UUID id);

    void updateRole(UpdateRoleDto updateRoleDto);
}
