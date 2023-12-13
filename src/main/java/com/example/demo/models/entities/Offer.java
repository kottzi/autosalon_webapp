package com.example.demo.models.entities;

import com.example.demo.models.enums.Engine;
import com.example.demo.models.enums.Transmission;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
    private String description;
    private Engine engine;
    private String imageURL;
    private int mileage;
    private int price;
    private Transmission transmission;
    private int year;
    private Model model;
    private User user;

    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "engine")
    @Enumerated(EnumType.STRING)
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Column(name = "image_url")
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column(name = "mileage")
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "transmission")
    @Enumerated(EnumType.STRING)
    public Transmission getTransmission() {
        return transmission;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public Offer(String description, Engine engine, String imageURL, int mileage, int price, Transmission transmission, int year, Model model, User user) {
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
    public Offer() {}

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {return user;}
    public void setUser(User user) {
        this.user = user;
    }
}
