package com.example.mobille.domein.dtos.binding;

import com.example.mobille.domein.entities.Model;
import com.example.mobille.domein.entities.User;
import com.example.mobille.domein.entities.enums.Engine;
import com.example.mobille.domein.entities.enums.Transmission;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferAddBindingModel {

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    private Engine engine;

    @NotNull
    @NotEmpty
    private String imageUrl;
    @NotNull
    @Positive
    private int mileage;


    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private Transmission transmission;

    @NotNull
    private Integer year;


    private LocalDateTime created;


    private LocalDateTime modified;

    @NotNull
    private Model model;



    private Long sellerId;

    public OfferAddBindingModel() {
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
