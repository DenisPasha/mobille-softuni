package com.example.mobille.serices.impl;


import com.example.mobille.domein.entities.UserRole;
import com.example.mobille.repositories.UserRoleRepository;
import com.example.mobille.serices.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public void save(UserRole userRole){
        userRoleRepository.save(userRole);
    }
}
