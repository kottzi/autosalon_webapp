package com.example.demo.models.entities;

import com.example.demo.models.enums.Category;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {
    private String name;
    private Category category;
    private String imageURL;
    private int startYear;
    private int endYear;

    private List<Offer> offers;
    private Brand brand;


    @Column(name = "name", unique = true, nullable = false)
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


    public Model(UUID id, LocalDate created, LocalDate modified, String name, Category category, String imageURL, int startYear, int endYear, List<Offer> offers, Brand brand) {
        super.id = id;
        super.created = created;
        super.modified = modified;
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.offers = offers;
        this.brand = brand;
    }

    public Model(LocalDate created, LocalDate modified, String name, Category category, String imageURL, int startYear, int endYear, List<Offer> offers, Brand brand) {
        super.created = created;
        super.modified = modified;
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.offers = offers;
        this.brand = brand;
    }

    public Model(String name, Category category, String imageURL, int startYear, int endYear, List<Offer> offers, Brand brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.offers = offers;
        this.brand = brand;
    }

    public Model(String name, Category category, String imageURL, int startYear, int endYear) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public Model() {}


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model", cascade = CascadeType.REMOVE)
    public List<Offer> getOffers() {
        return offers;
    }
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
