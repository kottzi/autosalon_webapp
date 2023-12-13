package com.example.demo.models.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    public UUID id;
    protected LocalDate created;
    protected LocalDate modified;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "created")
    public LocalDate getCreated() {
        return created;
    }
    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Column(name = "modified")
    public LocalDate getModified() {
        return modified;
    }
    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}