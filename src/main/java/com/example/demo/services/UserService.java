package com.example.demo.services;

import com.example.demo.services.dtos.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserDto create(UserDto userDto);
    UserDto addUser(UserDto userDto);
    void delete(UserDto userDto);
    void deleteById(UUID id);
    Optional<UserDto> findById(UUID id);
    List<UserDto> getAll();
    UserDto findUserByUsername(String username);
}
