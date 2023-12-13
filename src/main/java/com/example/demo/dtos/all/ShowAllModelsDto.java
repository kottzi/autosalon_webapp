package com.example.demo.dtos.all;

import com.example.demo.models.enums.Category;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowAllModelsDto implements Serializable {
    private String name;
    private Category category;
    private String imageURL;
}