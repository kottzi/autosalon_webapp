package com.example.demo.services.impl;

import com.example.demo.dtos.brand.BrandDto;
import com.example.demo.dtos.user.UserDto;
import com.example.demo.dtos.user.AddUserDto;
import com.example.demo.dtos.user.UpdateUserDto;
import com.example.demo.models.entities.Role;
import com.example.demo.models.entities.User;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @CacheEvict(cacheNames = "users", allEntries = true)
    @Override
    public void addUser(AddUserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        Role role = roleRepository.findRoleByUserRole(userDto.getRole().getUserRole()).orElseThrow();
        roleRepository.save(role);

        user.setRole(role);
        user.setCreated(LocalDate.now());
        userRepository.saveAndFlush(user);
    }

    @CacheEvict(cacheNames = "users", allEntries = true)
    @Override
    public void deleteUser(UserDto userDto) {
        userRepository.deleteById(userDto.getId());
    }

    @CacheEvict(cacheNames = "users", allEntries = true)
    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "users", allEntries = true)
    @Override
    public void deleteAllUsers() { userRepository.deleteAll(); }

    @Cacheable("users")
    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map((s) -> modelMapper.map(s, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRepository.findById(id), UserDto.class)).orElseThrow();
    }

    @Override
    public UserDto findUserByUsername(String username) {
        return Optional.ofNullable(modelMapper.map(userRepository.findUserByUsername(username), UserDto.class)).orElseThrow();
    }

    @Override
    public List<UserDto> findUsersByUsername(String username) {
        return userRepository.findUsersByUsername(username).stream().map((s) ->
                modelMapper.map(s, UserDto.class)).collect(Collectors.toList());
    }

    @CacheEvict(cacheNames = "users", allEntries = true)
    @Override
    public void updateUser(UpdateUserDto updateUserDto) {
        Optional<User> optionalUser = userRepository.findById(updateUserDto.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String password = user.getPassword();
            LocalDate created = user.getCreated();
            user = modelMapper.map(updateUserDto, User.class);

            Role role = roleRepository.findRoleByUserRole(updateUserDto.getRole().getUserRole()).orElseThrow();
            roleRepository.save(role);

            user.setRole(role);
            user.setPassword(password);
            user.setCreated(created);
            user.setModified(LocalDate.now());
            userRepository.saveAndFlush(user);
        }
    }
}
