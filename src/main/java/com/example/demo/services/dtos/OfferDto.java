package com.example.demo.services.dtos;

import com.example.demo.constants.Engine;
import com.example.demo.constants.Transmission;

import java.time.LocalDate;
import java.util.UUID;

public class OfferDto {
    private UUID id;
    private String description;
    private Engine engine;
    private String imageURL;
    private int mileage;
    private int price;
    private Transmission transmission;
    private int year;
    private LocalDate created;
    private LocalDate modified;
    private ModelDto model;
    private UserDto seller;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getImageUrl() {
        return imageURL;
    }

    public void setImageUrl(String imageURL) {
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

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    public OfferDto(UUID id, String description, Engine engine, String imageURL, int mileage, int price, Transmission transmission, int year, LocalDate created, LocalDate modified, ModelDto model, UserDto seller) {
        this.id = id;
        this.description = description;
        this.engine = engine;
        this.imageURL = imageURL;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.model = model;
        this.seller = seller;
    }
    public OfferDto(String description, Engine engine, String imageURL, int mileage, int price, Transmission transmission, int year, LocalDate created, LocalDate modified, ModelDto model, UserDto seller) {
        this.description = description;
        this.engine = engine;
        this.imageURL = imageURL;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.model = model;
        this.seller = seller;
    }
    public OfferDto() {}

    @Override
    public String toString() {
        return String.format("Offer with id = %s,\n description = %s,\n engine = %s,\n imageURL = %s,\n " +
                        "mileage = %d,\n price = %d,\n transmission = %s,\n year = %d",
                id, description, engine, imageURL, mileage, price, transmission, year);
    }
}
