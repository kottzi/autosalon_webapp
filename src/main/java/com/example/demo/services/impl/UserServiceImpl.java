package com.example.demo.services.impl;

import com.example.demo.services.dtos.UserDto;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDto create(UserDto userDto) {
        User s = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.save(s), UserDto.class);
    }
    @Override
    public UserDto addUser(UserDto userDto) {
        User s = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.save(s), UserDto.class);
    }
    @Override
    public void delete(UserDto userDto) {
        userRepository.deleteById(userDto.getId());
    }
    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
    @Override
    public Optional<UserDto> findById(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRepository.findById(id), UserDto.class));
    }
    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map((s) -> modelMapper.map(s, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findUserByUsername(String username) {
        return modelMapper.map(userRepository.findUserByUsername(username), UserDto.class);
    }
}
