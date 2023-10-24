package com.example.demo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends Base {

    private String name;

    @Column(name = "name")
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Brand(String name, Set<Model> models) {
        this.name = name;
        this.models = models;
    }
    public Brand() {}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.REFRESH)
    private Set<Model> models = new HashSet<>();
    public Set<Model> getModels() {return models;}
    public void setModels(Set<Model> models) {this.models = models;}

    @Override
    public String toString() {
        return String.format("Brand with id = %s,\n name = %s",
                id, name);
    }
}
