package com.example.demo.web.rest;

import com.example.demo.dtos.role.UpdateRoleDto;
import com.example.demo.dtos.user.UpdateUserDto;
import com.example.demo.dtos.user.UserDto;
import com.example.demo.dtos.user.AddUserDto;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/users")
public class UserRestController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {this.userService = userService;}

    @GetMapping
    List<UserDto> findAllUsers() {return userService.findAllUsers();}

    @GetMapping("/{id}")
    UserDto findUserById(@PathVariable UUID id) {
        return userService.findUserById(id);
    }

    @PostMapping
    void createUser(@RequestBody AddUserDto addUserDto) {userService.addUser(addUserDto);}

    @PutMapping
    void updateUser(@RequestBody UpdateUserDto updateUserDto) {userService.updateUser(updateUserDto);}

    @DeleteMapping
    void deleteAllUsers() {userService.deleteAllUsers();}
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable UUID id) {userService.deleteUserById(id);}
}
