package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import com.example.demo.models.entities.User;
import com.example.demo.models.entities.UserRole;
import com.example.demo.models.enums.Role;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final String defaultPassword;

    public DataInitializer(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, @Value("123456")String defaultPassword) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.defaultPassword = defaultPassword;
    }

    @Override
    public void run(String... args) throws Exception {
        initRoles();
        initUsers();
    }

    private void initAdmin(){
        var adminRole = userRoleRepository.findUserRoleByRole(Role.ADMIN);

        var adminUser = new User("kottzi", passwordEncoder.encode(defaultPassword), "Denis", "Levshenko", true);
        adminUser.setRole(adminRole);

        userRepository.save(adminUser);
    }
    private void initUser() {
        var userRole = userRoleRepository.findUserRoleByRole(Role.USER);

        var defaultUser = new User("yona4ka", passwordEncoder.encode(defaultPassword), "Yana", "Chirkova", true);
        defaultUser.setRole(userRole);

        userRepository.save(defaultUser);
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            var adminRole = new UserRole(Role.ADMIN);
            var defaultRole = new UserRole(Role.USER);
            userRoleRepository.save(adminRole);
            userRoleRepository.save(defaultRole);
        }
    }
    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initUser();
        }
    }
}