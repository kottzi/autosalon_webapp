package com.example.demo.dtos.update;

import com.example.demo.models.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateModelDto {
    private UUID id;
    private String name;
    private Category category;
    private int startYear;
}
