package com.example.demo.models.entities;

import com.example.demo.models.enums.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {
    private Role role;
    private List<User> users;

    public UserRole(Role role) {this.role = role;}
    public UserRole(Role role, List<User> users) {
        this.role = role;
        this.users = users;
    }
    public UserRole() {}

    @Column(name = "name", unique = true)
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
