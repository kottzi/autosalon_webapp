package com.example.demo.config;

import com.example.demo.models.enums.UserRole;
import org.springframework.beans.factory.annotation.Value;
import com.example.demo.models.entities.User;
import com.example.demo.models.entities.Role;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final String defaultPassword;

    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, @Value("123456")String defaultPassword) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.defaultPassword = defaultPassword;
    }

    @Override
    public void run(String... args) throws Exception {
        initRoles();
        initUsers();
    }

    private void initAdmin(){
        var adminRole = roleRepository.findRoleByUserRole(UserRole.ADMIN).orElseThrow();

        var adminUser = new User("kottzi", passwordEncoder.encode(defaultPassword), "Denis", "Levshenko", true);
        adminUser.setRole(adminRole);
        adminUser.setCreated(LocalDate.now());
        adminUser.setModified(LocalDate.now());

        userRepository.save(adminUser);
    }
    private void initUser() {
        var userRole = roleRepository.findRoleByUserRole(UserRole.USER).orElseThrow();

        var defaultUser = new User("yona4ka", passwordEncoder.encode(defaultPassword), "Yana", "Chirkova", true);
        defaultUser.setRole(userRole);
        defaultUser.setCreated(LocalDate.now());
        defaultUser.setModified(LocalDate.now());

        userRepository.save(defaultUser);
    }

    private void initRoles() {
        if (roleRepository.count() == 0) {
            var adminRole = new Role(UserRole.ADMIN);
            var defaultRole = new Role(UserRole.USER);
            roleRepository.save(adminRole);
            roleRepository.save(defaultRole);
        }
    }
    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initUser();
        }
    }
}