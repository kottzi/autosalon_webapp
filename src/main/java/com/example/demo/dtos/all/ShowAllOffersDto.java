package com.example.demo.dtos.all;

import com.example.demo.models.enums.Engine;
import com.example.demo.models.enums.Transmission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowAllOffersDto implements Serializable {
    private String description;
    private Engine engine;
    private String imageURL;
    private int mileage;
    private int price;
    private Transmission transmission;
    private int year;
}