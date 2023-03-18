package com.example.mobille.domein.entities;

import com.example.mobille.domein.entities.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{

    @Enumerated(EnumType.ORDINAL)
    private Role role ;

    public UserRole() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
