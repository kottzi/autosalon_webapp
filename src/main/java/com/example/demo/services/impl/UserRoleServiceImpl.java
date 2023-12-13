package com.example.demo.services.impl;

import com.example.demo.dtos.UserRoleDto;
import com.example.demo.dtos.add.AddUserRoleDto;
import com.example.demo.models.entities.UserRole;
import com.example.demo.repositories.UserRoleRepository;
import com.example.demo.services.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createUserRole(UserRoleDto userRoleDto) {
        userRoleRepository.saveAndFlush(modelMapper.map(userRoleDto, UserRole.class));
    }

    @Override
    public void addUserRole(AddUserRoleDto userRoleDto) {
        userRoleRepository.saveAndFlush(modelMapper.map(userRoleDto, UserRole.class));
    }
    @Override
    public void deleteUserRole(UserRoleDto userRoleDto) {
        userRoleRepository.deleteById(userRoleDto.getId());
    }
    @Override
    public void deleteUserRoleById(UUID id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public List<UserRoleDto> findAllUserRoles() {
        return userRoleRepository.findAll().stream().map((s) -> modelMapper.map(s, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserRoleDto findUserRoleById(UUID id) {
        return modelMapper.map(userRoleRepository.findById(id), UserRoleDto.class);
    }
}
