package com.example.demo.dtos.offer;

import com.example.demo.dtos.model.ModelDto;
import com.example.demo.dtos.user.UserDto;
import com.example.demo.models.enums.Engine;
import com.example.demo.models.enums.Transmission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

public class UpdateOfferDto {
    @Getter @Setter
    private UUID id;
    private String description;
    private Engine engine;
    private String imageURL;
    private int mileage;
    private int price;
    private Transmission transmission;
    private int year;
    private LocalDate modified;

    @Getter @Setter
    private ModelDto model;
    @Getter @Setter
    private UserDto user;


    @NotBlank(message = "Описание должно быть заполнено!")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Необходимо выбрать тип двигателя!")
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @NotNull(message = "Необходимо ввести ссылку на изображение!")
    @Size(min = 5)
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @NotNull(message = "Необходимо указать пробег!")
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @NotNull(message = "Необходимо указать цену!")
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @NotNull(message = "Необходимо выбрать тип трансмиссии!")
    public Transmission getTransmission() {
        return transmission;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @NotNull(message = "Необходимо указать год выпуска!")
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getModified() {
        return modified;
    }
    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}
