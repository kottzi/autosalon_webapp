package com.example.demo.services.dtos;

import java.time.LocalDate;
import java.util.UUID;

public class BrandDto {
    private UUID id;
    private String name;
    private LocalDate created;
    private LocalDate modified;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated() {
        return created;
    }
    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    public BrandDto(UUID id, String name, LocalDate created, LocalDate modified) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }
    public BrandDto(String name, LocalDate created, LocalDate modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }
    public BrandDto() {}

    @Override
    public String toString() {
        return String.format("Brand with id = %s,\n name = %s",
                id, name);
    }
}