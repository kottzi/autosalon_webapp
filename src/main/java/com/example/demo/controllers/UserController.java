package com.example.demo.controllers;

import com.example.demo.controllers.exceptions.UserNotFoundException;
import com.example.demo.services.dtos.UserDto;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {this.userService = userService;}

    @GetMapping
    List<UserDto> all() {return userService.getAll();}

    @GetMapping("/{id}")
    UserDto one(@PathVariable UUID id) throws Throwable {
        return (UserDto) userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping
    UserDto createUser(@RequestBody UserDto userDto) {return userService.create(userDto);}

    @PutMapping
    UserDto updateUser(@RequestBody UserDto userDto) {return userService.create(userDto);}

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable UUID id) {userService.deleteById(id);}
}
