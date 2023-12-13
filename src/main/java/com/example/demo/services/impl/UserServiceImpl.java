package com.example.demo.services.impl;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.add.AddUserDto;
import com.example.demo.dtos.all.ShowAllModelsDto;
import com.example.demo.dtos.all.ShowAllUsersDto;
import com.example.demo.models.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@EnableCaching
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createUser(UserDto userDto) {
        userRepository.saveAndFlush(modelMapper.map(userDto, User.class));
    }

    @Override
    public void addUser(AddUserDto userDto) {
        userRepository.saveAndFlush(modelMapper.map(userDto, User.class));
    }
    @Override
    public void deleteUser(UserDto userDto) {
        userRepository.deleteById(userDto.getId());
    }
    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }

    @Cacheable("users")
    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map((s) -> modelMapper.map(s, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(UUID id) {
        return modelMapper.map(userRepository.findById(id), UserDto.class);
    }

    @Override
    public List<ShowAllUsersDto> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username).stream().map((s) ->
                modelMapper.map(s, ShowAllUsersDto.class)).collect(Collectors.toList());
    }
}
