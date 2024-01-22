package com.example.demo.dtos.model;

import com.example.demo.dtos.offer.OfferDto;
import com.example.demo.dtos.brand.BrandDto;
import com.example.demo.models.enums.Category;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ModelDto {
    private UUID id;
    private LocalDate created;
    private LocalDate modified;

    private String name;
    private Category category;
    private String imageURL;
    private int startYear;
    private int endYear;

    private List<OfferDto> offers;
    private BrandDto brand;


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

    public List<OfferDto> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferDto> offers) {
        this.offers = offers;
    }

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }


    public ModelDto(UUID id, LocalDate created, LocalDate modified, String name, Category category, String imageURL, int startYear, int endYear, List<OfferDto> offers, BrandDto brand) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.offers = offers;
        this.brand = brand;
    }

    public ModelDto(LocalDate created, LocalDate modified, String name, Category category, String imageURL, int startYear, int endYear, List<OfferDto> offers, BrandDto brand) {
        this.created = created;
        this.modified = modified;
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.offers = offers;
        this.brand = brand;
    }

    public ModelDto(String name, Category category, String imageURL, int startYear, int endYear, List<OfferDto> offers, BrandDto brand) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
        this.offers = offers;
        this.brand = brand;
    }

    public ModelDto(String name, Category category, String imageURL, int startYear, int endYear) {
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public ModelDto() {}
}
