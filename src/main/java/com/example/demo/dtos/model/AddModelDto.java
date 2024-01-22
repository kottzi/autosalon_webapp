package com.example.demo.dtos.model;

import com.example.demo.dtos.brand.BrandDto;
import com.example.demo.dtos.offer.OfferDto;
import com.example.demo.models.enums.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class AddModelDto {
    private String name;
    private Category category;
    private String imageURL;
    private int startYear;
    private int endYear;
    private LocalDate created;

    @Getter @Setter
    private BrandDto brand;
    @Getter @Setter
    private List<OfferDto> offers;


    @NotEmpty(message = "Model name must not be null or empty!")
    @Size(min = 2, max = 25, message = "Model name must be between 2 and 25 characters!")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Category cannot be null or empty!")
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @NotEmpty(message = "ImageURL cannot be null or empty!")
    @Size(min = 5)
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @NotNull(message = "StartYear cannot be null or empty!")
    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @NotNull(message = "EndYear cannot be null or empty!")
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
}