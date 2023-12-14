package com.example.demo.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    private String name;
    private List<Model> models;

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

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
