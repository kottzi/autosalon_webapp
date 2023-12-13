package com.example.demo.web;

import com.example.demo.dtos.UserRoleDto;
import com.example.demo.dtos.add.AddUserRoleDto;
import com.example.demo.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/roles")
public class UserRoleController {
    private UserRoleService roleService;
    @Autowired
    public void setRoleService(UserRoleService roleService) {this.roleService = roleService;}

    @GetMapping
    List<UserRoleDto> findAllRoles() {return roleService.findAllUserRoles();}

    @GetMapping("/{id}")
    UserRoleDto findUserById(@PathVariable UUID id) {
        return roleService.findUserRoleById(id);
    }

    @PostMapping
    void createRole(@RequestBody AddUserRoleDto roleDto) {roleService.addUserRole(roleDto);}

    @PutMapping
    void updateRole(@RequestBody AddUserRoleDto roleDto) {roleService.addUserRole(roleDto);}

    @DeleteMapping("/{id}")
    void deleteRole(@PathVariable UUID id) {roleService.deleteUserRoleById(id);}
}
