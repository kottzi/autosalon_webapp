package com.example.demo.web.rest;

import com.example.demo.dtos.role.RoleDto;
import com.example.demo.dtos.role.AddRoleDto;
import com.example.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
    private RoleService roleService;
    @Autowired
    public void setRoleService(RoleService roleService) {this.roleService = roleService;}

    @GetMapping
    List<RoleDto> findAllRoles() {return roleService.findAllRoles();}

    @GetMapping("/{id}")
    RoleDto findUserById(@PathVariable UUID id) {
        return roleService.findRoleById(id);
    }

    @PostMapping
    void createRole(@RequestBody AddRoleDto roleDto) {roleService.addRole(roleDto);}

    @PutMapping
    void updateRole(@RequestBody AddRoleDto roleDto) {roleService.addRole(roleDto);}

    @DeleteMapping("/{id}")
    void deleteRole(@PathVariable UUID id) {roleService.deleteRoleById(id);}
}
