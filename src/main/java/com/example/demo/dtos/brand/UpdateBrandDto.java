package com.example.demo.dtos.brand;

import com.example.demo.dtos.model.ModelDto;
import com.example.demo.utils.validation.UniqueBrandName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class UpdateBrandDto {
    @Getter @Setter
    private UUID id;
    private String name;
    private LocalDate modified;

    @Getter @Setter
    private List<ModelDto> models;


    @UniqueBrandName
    @NotEmpty(message = "Brand name must not be null or empty!")
    @Size(min = 2, max = 25, message = "Brand name must be between 2 and 25 characters!")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getModified() {
        return modified;
    }
    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}
