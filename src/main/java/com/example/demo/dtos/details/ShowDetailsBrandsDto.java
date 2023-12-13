package com.example.demo.dtos.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowDetailsBrandsDto {
    private String name;
    private LocalDate created;
    private LocalDate modified;
}