package com.example.mobille.domein.dtos.service;

import com.example.mobille.domein.entities.Model;
import com.example.mobille.domein.entities.User;
import com.example.mobille.domein.entities.enums.Engine;
import com.example.mobille.domein.entities.enums.Transmission;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UpdateOfferServiceModel {

    private Long id;

    private String description;

    private Engine engine;
    //•	imageUrl – the url of image.

    private String imageUrl;
    //•	mileage – a number.

    private int mileage;
    //•	price – the price of the offer.

    private BigDecimal price;
    //•	transmission – enumerated value (MANUAL, AUTOMATIC).

    private Transmission transmission;
    //•	year – the year of offered car.

    private Integer year;
    //•	created – a date and time.

    private LocalDateTime created;
    //•	modified – a date and time.

    private LocalDateTime modified;
    //•	model – the model of a car.

    private Model model;
    //•	seller – a user that sells the car.

    private User seller;

    public UpdateOfferServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
