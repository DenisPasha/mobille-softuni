package com.example.mobille.domein.dtos.binding;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterBindingUserModel {

    @Size(min = 5)
    private String firstName;

    @Size(min = 3)
    private String lastName;

    @Size(min = 2)
    private String username ;

    @Size(min = 5)
    private String password;


    public RegisterBindingUserModel() {
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
