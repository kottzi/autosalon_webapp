package com.example.demo.services;

import com.example.demo.services.dtos.UserRoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRoleService {
    UserRoleDto create(UserRoleDto userRoleDto);
    void delete(UserRoleDto userRoleDto);
    void deleteById(UUID id);
    Optional<UserRoleDto> findById(UUID id);
    List<UserRoleDto> getAll();
}
