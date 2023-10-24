package com.example.demo.models;

import com.example.demo.constants.Role;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;;

@Entity
@Table(name = "roles")
public class UserRole {

    public UUID id;
    private Role role;

    public UserRole(Role role, Set<User> users) {
        this.role = role;
        this.users = users;
    }
    public UserRole() {}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.REMOVE)
    private Set<User> users = new HashSet<>();
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return String.format("Role with id = %s, name = %s", id, role);
    }
}
