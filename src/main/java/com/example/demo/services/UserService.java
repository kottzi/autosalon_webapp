package com.example.demo.services;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.add.AddUserDto;
import com.example.demo.dtos.all.ShowAllUsersDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void createUser(UserDto userDto);

    void addUser(AddUserDto userDto);
    void deleteUser(UserDto userDto);
    void deleteUserById(UUID id);

    List<UserDto> findAllUsers();
    UserDto findUserById(UUID id);
    List<ShowAllUsersDto> findUserByUsername(String username);
}
