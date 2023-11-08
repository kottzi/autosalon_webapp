package com.example.demo.controllers;

import com.example.demo.controllers.exceptions.UserRoleNotFoundException;
import com.example.demo.services.dtos.UserRoleDto;
import com.example.demo.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class UserRoleController {
    private UserRoleService roleService;
    @Autowired
    public void setRoleService(UserRoleService roleService) {this.roleService = roleService;}

    @GetMapping
    Iterable<UserRoleDto> all() {return roleService.getAll();}

    @GetMapping("/{id}")
    UserRoleDto one(@PathVariable UUID id) throws Throwable {
        return (UserRoleDto) roleService.findById(id).orElseThrow(() -> new UserRoleNotFoundException(id));
    }

    @PostMapping
    UserRoleDto updateRole(@RequestBody UserRoleDto roleDto) {return roleService.create(roleDto);}

    @PutMapping
    UserRoleDto newRole(@RequestBody UserRoleDto roleDto) {return roleService.create(roleDto);}

    @DeleteMapping("/{id}")
    void deleteRole(@PathVariable UUID id) {roleService.deleteById(id);}
}
