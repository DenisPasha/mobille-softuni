package com.example.mobille.web;

import com.example.mobille.domein.dtos.binding.LoginBindingUserModel;
import com.example.mobille.domein.entities.User;
import com.example.mobille.serices.UserService;
import com.example.mobille.util.CurrentUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    private final UserService userService;
    public CurrentUser currentUser;
    private final ModelMapper modelMapper;


    public LoginController(UserService userService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userService = userService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;

    }
    @ModelAttribute
    public LoginBindingUserModel loginBindingUserModel(){
        return new LoginBindingUserModel();
    }

    public CurrentUser getCurrentUser (){
        if (currentUser==null){
            return new CurrentUser();
        }
        return currentUser;
    }
    @GetMapping("users/login")
    public String getLogin(Model model){
        return "auth-login";
    }

    @PostMapping("users/login")
    public String postLogin(@Valid LoginBindingUserModel loginBindingUserModel ,
                            BindingResult bindingResult ,
                            RedirectAttributes redirectAttributes,Model model){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginBindingUserModel",loginBindingUserModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginBindingUserModel",bindingResult);
            return "redirect:login";
        }
        Boolean isUserLoggedIn = userService.findUserByUsernameAndPassword(loginBindingUserModel.getUsername(), loginBindingUserModel.getPassword());
        if (isUserLoggedIn){
            return "redirect:/";
        }

        return "redirect:users/login";
    }


}
