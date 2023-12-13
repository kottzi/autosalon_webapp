package com.example.demo.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    private String name;
    private Set<Model> models = new HashSet<>();

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Brand(String name, Set<Model> models) {
        this.name = name;
        this.models = models;
    }
    public Brand() {}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.REFRESH)
    public Set<Model> getModels() {return models;}
    public void setModels(Set<Model> models) {this.models = models;}
}
