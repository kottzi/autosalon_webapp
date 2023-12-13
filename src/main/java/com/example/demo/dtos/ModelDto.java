package com.example.demo.dtos;

import com.example.demo.models.enums.Category;

import java.time.LocalDate;
import java.util.UUID;

public class ModelDto {
    private UUID id;
    private String name;
    private Category category;
    private String imageURL;
    private int startYear;
    private int endYear;
    private LocalDate created;
    private LocalDate modified;
    private BrandDto brand;


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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
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

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    public ModelDto(UUID id, String name, Category category, String imageURL, int startYear, int endYear, LocalDate created, LocalDate modified, BrandDto brand) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
    }
    public ModelDto(String name, Category category, String imageURL, int startYear, int endYear, LocalDate created, LocalDate modified, BrandDto brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
    }
    public ModelDto() {}
}
