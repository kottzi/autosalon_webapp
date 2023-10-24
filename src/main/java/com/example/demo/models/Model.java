package com.example.demo.models;

import com.example.demo.constants.Category;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "models")
public class Model extends Base {

    private String name;
    private Category category;
    private String imageURL;
    private int startYear;
    private int endYear;

    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "image_url")
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column(name = "start_year")
    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Column(name = "end_year")
    public int getEndYear() {
        return endYear;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Model(String name, Category category, String imageURL, int startYear, int endYear, Set<Offer> offers, Brand brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.offers = offers;
        this.brand = brand;
    }
    public Model() {}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model", cascade = CascadeType.REMOVE)
    private Set<Offer> offers = new HashSet<>();
    public Set<Offer> getOffers() {
        return offers;
    }
    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("Model with id = %s,\n name = %s,\n startYear = %d,\n endYear = %d",
                id, name, startYear, endYear);
    }
}
