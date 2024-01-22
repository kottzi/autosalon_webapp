package com.example.demo.dtos.offer;

import com.example.demo.dtos.user.UserDto;
import com.example.demo.dtos.model.ModelDto;
import com.example.demo.models.enums.Engine;
import com.example.demo.models.enums.Transmission;

import java.time.LocalDate;
import java.util.UUID;

public class OfferDto {
    private UUID id;
    private LocalDate created;
    private LocalDate modified;

    private String description;
    private Engine engine;
    private String imageURL;
    private int mileage;
    private int price;
    private Transmission transmission;
    private int year;

    private ModelDto model;
    private UserDto user;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }


    public OfferDto(UUID id, LocalDate created, LocalDate modified, String description, Engine engine, String imageURL, int mileage, int price, Transmission transmission, int year, ModelDto model, UserDto user) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.description = description;
        this.engine = engine;
        this.imageURL = imageURL;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.user = user;
    }

    public OfferDto(LocalDate created, LocalDate modified, String description, Engine engine, String imageURL, int mileage, int price, Transmission transmission, int year, ModelDto model, UserDto user) {
        this.created = created;
        this.modified = modified;
        this.description = description;
        this.engine = engine;
        this.imageURL = imageURL;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.user = user;
    }

    public OfferDto(String description, Engine engine, String imageURL, int mileage, int price, Transmission transmission, int year, ModelDto model, UserDto user) {
        this.description = description;
        this.engine = engine;
        this.imageURL = imageURL;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.user = user;
    }

    public OfferDto(String description, Engine engine, String imageURL, int mileage, int price, Transmission transmission, int year) {
        this.description = description;
        this.engine = engine;
        this.imageURL = imageURL;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
    }

    public OfferDto() {}
}
