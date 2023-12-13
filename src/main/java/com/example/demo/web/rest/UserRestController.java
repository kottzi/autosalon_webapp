package com.example.demo.web.rest;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.add.AddUserDto;
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
    void createUser(@RequestBody AddUserDto userDto) {userService.addUser(userDto);}

    @PutMapping
    void updateUser(@RequestBody AddUserDto userDto) {userService.addUser(userDto);}

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable UUID id) {userService.deleteUserById(id);}
}
