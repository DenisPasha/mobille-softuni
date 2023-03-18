package com.example.mobille.web;

import com.example.mobille.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    private final CurrentUser currentUser;

    public LogoutController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/users/logout")
    public String getLogout(){
        currentUser.setUsername(null);
        currentUser.setId(null);
        return "redirect:/";
    }
}
