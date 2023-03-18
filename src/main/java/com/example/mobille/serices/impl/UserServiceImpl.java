package com.example.mobille.serices.impl;


import com.example.mobille.domein.dtos.binding.RegisterBindingUserModel;
import com.example.mobille.domein.entities.User;
import com.example.mobille.repositories.UserRepository;
import com.example.mobille.serices.UserRoleService;
import com.example.mobille.serices.UserService;
import com.example.mobille.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserRoleService userRoleService;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, UserRoleService userRoleService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userRoleService = userRoleService;
        this.currentUser = currentUser;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void registerUser(RegisterBindingUserModel registerBindingUserModel) {

        User user = modelMapper.map(registerBindingUserModel, User.class);

        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setActive(true);


        saveUser(user);
    }


    @Override
    public Boolean isUserExist(String username) {
       return this.userRepository.findByUsername(username).isPresent();
    }

    @Override
    public Boolean findUserByUsernameAndPassword(String username , String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password).orElse(null);
        if (user!=null){
            currentUser.setId(user.getId());
            currentUser.setUsername(user.getUsername());
            return true;
        }
        return false;
    }

    @Override
    public CurrentUser loginUser(User curUser) {
        return modelMapper.map(curUser, CurrentUser.class);
    }

    @Override
    public User finbyId(Long id) {
        return this.userRepository.findById(id);
    }
}