package com.example.demo.web;

import com.example.demo.dtos.role.RoleDto;
import com.example.demo.dtos.user.AddUserDto;
import com.example.demo.dtos.user.UserDto;
import com.example.demo.dtos.user.UpdateUserDto;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private RoleService roleService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @ModelAttribute("addUser")
    public AddUserDto initUser() {return new AddUserDto();}
    @ModelAttribute("roles")
    public List<RoleDto> findAllRoles() {return roleService.findAllRoles();}

    @GetMapping("/all")
    public String showUsers(Model model, Principal principal) {
        model.addAttribute("showUsers", userService.findAllUsers());

        LOG.log(Level.INFO, String.format("Show all users for %s", principal.getName()));
        return "/user-all";
    }

    @RequestMapping("/search")
    public String searchModels(@RequestParam(name = "username", required = false) String username, Model model) {
        List<UserDto> searchResults = userService.findUsersByUsername(username);
        model.addAttribute("searchResults", searchResults);
        return "/user-search";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable UUID id, Model model) {
        UserDto userDto = userService.findUserById(id);
        model.addAttribute("updateUser", userDto);
        return "/user-update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute UpdateUserDto updateUserDto) {
        userService.updateUser(updateUserDto);
        return "redirect:/users/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBrand(@PathVariable UUID id, Principal principal) {
        userService.deleteUserById(id);

        LOG.log(Level.INFO, String.format("Delete a user with nickname %s by %s",
                userService.findUserById(id).getUsername(), principal.getName()));
        return "redirect:/users/all";
    }

    // Setter Injection
    @Autowired
    public void setUserService(UserService userService) {this.userService = userService;}
    @Autowired
    public void setRoleService(RoleService roleService) {this.roleService = roleService;}
}
