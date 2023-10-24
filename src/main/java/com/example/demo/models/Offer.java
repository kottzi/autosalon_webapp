package com.example.demo.models;

import com.example.demo.constants.Engine;
import com.example.demo.constants.Transmission;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class Offer extends Base {

    private String description;
    private Engine engine;
    private String imageURL;
    private int mileage;
    private int price;
    private Transmission transmission;
    private int year;

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

    public Offer(String description, Engine engine, String imageURL, int mileage, int price, Transmission transmission, int year, Model model, User seller) {
        this.description = description;
        this.engine = engine;
        this.imageURL = imageURL;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.seller = seller;
    }

    public Offer() {}

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Model model;
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User seller;
    public User getSeller() {
        return seller;
    }
    public void setSeller(User seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return String.format("Offer with id = %s,\n description = %s,\n engine = %s,\n imageURL = %s,\n " +
                "mileage = %d,\n price = %d,\n transmission = %s,\n year = %d",
                id, description, engine, imageURL, mileage, price, transmission, year);
    }
}
