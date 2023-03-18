package com.example.mobille.domein.dtos.binding;

import jakarta.validation.constraints.Size;

public class LoginBindingUserModel {
    @Size(min = 2)
    private String username;
    @Size(min = 6)
    private String password;

    private Long id;

    public LoginBindingUserModel() {
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
