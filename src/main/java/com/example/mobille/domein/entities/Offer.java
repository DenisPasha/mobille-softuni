package com.example.mobille.domein.entities;

import com.example.mobille.domein.entities.enums.Engine;
import com.example.mobille.domein.entities.enums.Transmission;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    //•	description – some text.
    @Column
    private String description;
    //•	engine – enumerated value (GASOLINE, DIESEL, ELECTRIC, HYBRID).
    @Enumerated(EnumType.ORDINAL)
    private Engine engine;
    //•	imageUrl – the url of image.
    @Column
    private String imageUrl;
    //•	mileage – a number.
    @Column
    private int mileage;
    //•	price – the price of the offer.
    @Column
    private BigDecimal price;
    //•	transmission – enumerated value (MANUAL, AUTOMATIC).
    @Enumerated(EnumType.ORDINAL)
    private Transmission transmission;
    //•	year – the year of offered car.
    @Column
    private Integer year;
    //•	created – a date and time.
    @Column
    private LocalDateTime created;
    //•	modified – a date and time.
    @Column
    private LocalDateTime modified;
    //•	model – the model of a car.
    @ManyToOne
    private Model model;
    //•	seller – a user that sells the car.
    @ManyToOne
    private User seller;

    public Offer() {
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
