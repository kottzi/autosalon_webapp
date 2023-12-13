package com.example.demo.dtos.add;

import com.example.demo.models.enums.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class AddModelDto {
    private String name;
    private Category category;
    private String imageURL;
    private int startYear;
    private int endYear;

    @Getter
    @Setter
    private String showAllBrandsDto;

    @NotEmpty(message = "Model name must not be null or empty!")
    @Size(min = 3, max = 25, message = "Brand name must be between 3 and 25 characters!")
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

    @NotNull(message = "")
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @NotNull(message = "")
    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
}
