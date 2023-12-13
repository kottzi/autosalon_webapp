package com.example.demo.repositories;

import com.example.demo.models.entities.UserRole;
import com.example.demo.models.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    UserRole findUserRoleByRole(Role role);
}
