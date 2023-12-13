package com.example.demo.dtos.details;

import com.example.demo.models.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowDetailsModelsDto {
    private String name;
    private Category category;
    private String imageURL;
    private int startYear;
    private int endYear;
}