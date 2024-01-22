package com.example.demo.web;

import com.example.demo.dtos.role.AddRoleDto;
import com.example.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private RoleService roleService;

    @ModelAttribute("addRole")
    public AddRoleDto initRole() {return new AddRoleDto();}

    @Autowired
    public void setRoleService(RoleService roleService) {this.roleService = roleService;}
}
