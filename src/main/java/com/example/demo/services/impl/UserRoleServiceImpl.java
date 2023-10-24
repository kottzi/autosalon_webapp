package com.example.demo.services.impl;

import com.example.demo.services.dtos.UserRoleDto;
import com.example.demo.models.UserRole;
import com.example.demo.repositories.UserRoleRepository;
import com.example.demo.services.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserRoleDto create(UserRoleDto UserRoleDto) {
        UserRole s = modelMapper.map(UserRoleDto, UserRole.class);
        return modelMapper.map(userRoleRepository.save(s), UserRoleDto.class);
    }
    @Override
    public void delete(UserRoleDto UserRoleDto) {
        userRoleRepository.deleteById(UserRoleDto.getId());
    }
    @Override
    public void deleteById(UUID id) {
        userRoleRepository.deleteById(id);
    }
    @Override
    public Optional<UserRoleDto> findById(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRoleRepository.findById(id), UserRoleDto.class));
    }
    @Override
    public List<UserRoleDto> getAll() {
        return userRoleRepository.findAll().stream().map((s) -> modelMapper.map(s, UserRoleDto.class)).collect(Collectors.toList());
    }
}
