package com.example.demo.dtos.add;

import com.example.demo.utils.validation.UniqueBrandName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AddBrandDto {
    private String name;
    private LocalDate created;
    private LocalDate modified;

    @UniqueBrandName
    @NotEmpty(message = "Brand name must not be null or empty!")
    @Size(min = 3, max = 25, message = "Brand name must be between 3 and 25 characters!")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Brand's created date must not be null or empty!")
    public LocalDate getCreated() {
        return created;
    }
    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @NotNull(message = "Brand's modified date must not be null or empty!")
    public LocalDate getModified() {
        return modified;
    }
    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}
