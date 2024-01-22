package com.example.demo.models.entities;

import com.example.demo.models.enums.UserRole;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private UserRole userRole;

    private List<User> users;


    @Column(name = "role", unique = true)
    @Enumerated(EnumType.STRING)
    public UserRole getUserRole() {
        return userRole;
    }
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Role(UUID id, UserRole userRole, List<User> users) {
        super.id = id;
        this.userRole = userRole;
        this.users = users;
    }

    public Role(UserRole userRole, List<User> users) {
        this.userRole = userRole;
        this.users = users;
    }
    public Role(UserRole userRole) { this.userRole = userRole; }
    public Role() {}


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
