package com.example.demo.web;

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
}
