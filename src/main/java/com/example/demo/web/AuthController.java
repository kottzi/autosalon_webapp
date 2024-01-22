package com.example.demo.web;

import com.example.demo.views.UserProfileView;
import com.example.demo.dtos.UserRegistrationDto;
import com.example.demo.models.entities.User;
import com.example.demo.services.security.AuthService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class AuthController {
    private AuthService authService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @ModelAttribute("userRegistration")
    public UserRegistrationDto init() {return new UserRegistrationDto();}

    @GetMapping("/register")
    public String register() {
        return "/register";
    }
    @GetMapping("/login")
    public String login() {
        return "/login";
    }
    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        LOG.log(Level.INFO, String.format("%s open a profile",
                principal.getName()));
        String username = principal.getName();
        User user = authService.getUser(username);

        UserProfileView userProfileView = new UserProfileView(username, user.getFirstName(), user.getLastName(), user.getRole());
        model.addAttribute("user", userProfileView);
        return "profile";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegistrationDto userRegistrationDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        LOG.log(Level.INFO, String.format("Register a new user - %s",
                userRegistrationDto.getUsername()));
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegistration", userRegistrationDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistration", bindingResult);
            return "redirect:/register";
        }
        this.authService.register(userRegistrationDto);
        return "redirect:/login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
        redirectAttributes.addFlashAttribute("badCredentials", true);

        return "redirect:/login";
    }

    // Setter Injection
    @Autowired
    public void setAuthService(AuthService authService) {this.authService = authService;}
}
