package com.example.demo.models.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    private String name;

    private List<Model> models;

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


    public Brand(UUID id, LocalDate created, LocalDate modified, String name, List<Model> models) {
        super.id = id;
        super.created = created;
        super.modified = modified;
        this.name = name;
        this.models = models;
    }

    public Brand(LocalDate created, LocalDate modified, String name, List<Model> models) {
        super.created = created;
        super.modified = modified;
        this.name = name;
        this.models = models;
    }

    public Brand(String name, List<Model> models) {
        this.name = name;
        this.models = models;
    }
    public Brand(String name) {
        this.name = name;
    }
    public Brand() {}


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.REFRESH)
    public List<Model> getModels() {return models;}
    public void setModels(List<Model> models) {this.models = models;}
}
