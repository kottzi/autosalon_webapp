package com.example.demo.dtos.all;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowAllBrandsDto implements Serializable {
    private String name;
}