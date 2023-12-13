package com.example.demo.services.security;

import com.example.demo.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class AppUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .filter(u -> u.getIsActive())
                .map(u -> new User(
                        u.getUsername(),
                        u.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority(u.getRole().getRole().name()))
                )).orElseThrow(() -> new UsernameNotFoundException(username + " не найден или аккаунт не активен!"));
    }
}