package com.example.mobille.domein.dtos.binding;

import com.example.mobille.domein.entities.Model;
import com.example.mobille.domein.entities.User;
import com.example.mobille.domein.entities.enums.Engine;
import com.example.mobille.domein.entities.enums.Transmission;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferUpdateBindingModel {

    @NotNull
    private Long id;


    @NotNull
    private String description;

    @NotNull
    private Engine engine;
    //•	imageUrl – the url of image.

    @NotNull
    private String imageUrl;
    //•	mileage – a number.

    @NotNull
    private int mileage;
    //•	price – the price of the offer.

    @NotNull
    private BigDecimal price;
    //•	transmission – enumerated value (MANUAL, AUTOMATIC).

    @NotNull
    private Transmission transmission;
    //•	year – the year of offered car.

    @NotNull
    private Integer year;
    //•	created – a date and time.


    private LocalDateTime created;
    //•	modified – a date and time.


    private LocalDateTime modified;
    //•	model – the model of a car.

    @NotNull
    private Model model;
    //•	seller – a user that sells the car.

    private Long sellerId;

    public OfferUpdateBindingModel() {
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

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
