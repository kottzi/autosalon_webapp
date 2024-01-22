package com.example.demo.services;

import com.example.demo.dtos.user.UserDto;
import com.example.demo.dtos.user.AddUserDto;
import com.example.demo.dtos.user.UpdateUserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void addUser(AddUserDto addUserDto);

    void deleteUser(UserDto userDto);
    void deleteUserById(UUID id);
    void deleteAllUsers();

    List<UserDto> findAllUsers();
    UserDto findUserById(UUID id);
    UserDto findUserByUsername(String username);
    List<UserDto> findUsersByUsername(String username);

    void updateUser(UpdateUserDto updateUserDto);
}
