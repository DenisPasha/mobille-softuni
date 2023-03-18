package com.example.mobille.web;

import com.example.mobille.domein.dtos.binding.RegisterBindingUserModel;
import com.example.mobille.serices.UserService;
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
public class RegisterController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public RegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public RegisterBindingUserModel registerUserDto(){
        return new RegisterBindingUserModel();
    }

 @GetMapping("/users/register")
 public String getRegister(Model model){
     return "auth-register";
 }

    @PostMapping("users/register")
    public String getData(@Valid RegisterBindingUserModel registerBindingUserModel  , BindingResult bindingResult , RedirectAttributes redirectAttributes){

     if (bindingResult.hasErrors()){
         redirectAttributes.addFlashAttribute("registerBindingUserModel",registerBindingUserModel);
         redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUserDto",bindingResult);
         return "redirect:register";
     }

        Boolean userExist = userService.isUserExist(registerBindingUserModel.getUsername());
     if (userExist){
         redirectAttributes.addFlashAttribute("userExists", true);
         return "redirect:register";
     }
        userService.registerUser(registerBindingUserModel);
        return "redirect:login";
    }


}
