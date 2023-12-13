package com.example.demo.web;

import com.example.demo.dtos.all.ShowAllUsersDto;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {this.userService = userService;}

    @GetMapping("/all")
    public String showBrands(Model model) {
        model.addAttribute("showUsers", userService.findAllUsers());
        return "/user-all";
    }

    @RequestMapping("/search")
    public String searchModels(@RequestParam(name = "username", required = false) String username, Model model) {
        List<ShowAllUsersDto> searchResults = userService.findUserByUsername(username);
        model.addAttribute("searchResults", searchResults);
        return "/user-search";
    }
}
