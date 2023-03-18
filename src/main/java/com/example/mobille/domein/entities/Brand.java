package com.example.mobille.domein.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{

//•	name – a name of brand.
    @Column
    private String name;
//•	created – a date and time.
    @Column
    private LocalDateTime created;

//•	modified – a date and time.
    @Column
    private LocalDateTime modified;

    @OneToMany
    private Set<Model> models;

    public Brand() {
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
