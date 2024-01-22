package com.example.demo.services.security;

import com.example.demo.dtos.UserRegistrationDto;
import com.example.demo.models.entities.User;
import com.example.demo.models.enums.UserRole;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void register(UserRegistrationDto userRegistrationDto) {
        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }
        var userRole = roleRepository.findRoleByUserRole(UserRole.USER).orElseThrow();

        User user = new User(
                userRegistrationDto.getUsername(),
                passwordEncoder.encode(userRegistrationDto.getPassword()),
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                true
        );
        user.setRole(userRole);
        this.userRepository.save(user);
    }

    public User getUser(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " не найден!"));
    }
}
