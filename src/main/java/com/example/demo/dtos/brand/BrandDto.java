package com.example.demo.dtos.brand;

import com.example.demo.dtos.model.ModelDto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class BrandDto implements Serializable {
    private UUID id;
    private LocalDate created;
    private LocalDate modified;

    private String name;

    private List<ModelDto> models;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelDto> getModels() {
        return models;
    }

    public void setModels(List<ModelDto> models) {
        this.models = models;
    }


    public BrandDto(UUID id, LocalDate created, LocalDate modified, String name, List<ModelDto> models) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.name = name;
        this.models = models;
    }

    public BrandDto(LocalDate created, LocalDate modified, String name, List<ModelDto> models) {
        this.created = created;
        this.modified = modified;
        this.name = name;
        this.models = models;
    }

    public BrandDto(String name, List<ModelDto> models) {
        this.name = name;
        this.models = models;
    }

    public BrandDto(String name) {
        this.name = name;
    }

    public BrandDto() {}
}