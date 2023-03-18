package com.example.mobille.serices;

import com.example.mobille.domein.dtos.binding.RegisterBindingUserModel;
import com.example.mobille.domein.entities.User;
import com.example.mobille.util.CurrentUser;

public interface UserService {

    void saveUser(User user);


    void registerUser(RegisterBindingUserModel registerBindingUserModel);

    Boolean isUserExist(String username);

    Boolean findUserByUsernameAndPassword(String username, String password);

    CurrentUser loginUser(User curUser);

    User finbyId(Long id);

}
