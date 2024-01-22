package com.example.demo.services.impl;

import com.example.demo.dtos.brand.UpdateBrandDto;
import com.example.demo.dtos.role.AddRoleDto;
import com.example.demo.dtos.role.RoleDto;
import com.example.demo.dtos.role.UpdateRoleDto;
import com.example.demo.models.entities.Brand;
import com.example.demo.models.entities.Role;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addRole(AddRoleDto userRoleDto) {
        Role role = modelMapper.map(userRoleDto, Role.class);

        role.setCreated(LocalDate.now());
        roleRepository.saveAndFlush(role);
    }

    @Override
    public void deleteRole(RoleDto roleDto) {
        roleRepository.deleteById(roleDto.getId());
    }
    @Override
    public void deleteRoleById(UUID id) {
        roleRepository.deleteById(id);
    }
    @Override
    public void deleteAllRoles() {
        roleRepository.deleteAll();
    }

    @Override
    public List<RoleDto> findAllRoles() {
        return roleRepository.findAll().stream().map((s) -> modelMapper.map(s, RoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public RoleDto findRoleById(UUID id) {
        return Optional.ofNullable(modelMapper.map(roleRepository.findById(id), RoleDto.class)).orElseThrow();
    }

    @Override
    public void updateRole(UpdateRoleDto updateRoleDto) {
        Optional<Role> optionalRole = roleRepository.findById(updateRoleDto.getId());
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();

            role.setUserRole(updateRoleDto.getUserRole());
            role.setModified(LocalDate.now());
            roleRepository.saveAndFlush(role);
        }
    }
}
