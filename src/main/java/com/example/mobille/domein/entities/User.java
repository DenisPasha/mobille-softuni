package com.example.mobille.domein.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users" )
public class User extends BaseEntity{
    //•	username –  username of the user.
    @Column
    private String username;
    //•	password – password of the user.
    @Column
    private String password;
    //•	firstName –  first name of the user.
    @Column
    private String firstName;

    //•	lastName –  last name of the user.
    @Column
    private String lastName;
    //•	isActive – true OR false.
    @Column
    private Boolean isActive;
    //•	role –  user's role (User or Admin).
    @OneToOne
    private UserRole userRole;

    //•	imageUrl – a url of user's picture.
    @Column
    private String imageUrl;

    //•	created – a date and time.
    @Column
    private LocalDateTime created;

    //•	modified – a date and time
    @Column
    private LocalDateTime modified;


    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

