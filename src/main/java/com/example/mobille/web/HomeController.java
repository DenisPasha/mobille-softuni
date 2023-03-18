package com.example.mobille.web;

import com.example.mobille.util.CurrentUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    public HomeController(@ModelAttribute CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String home(Model model , RedirectAttributes redirectAttributes){
        if (!model.containsAttribute("currentUser")){
            model.addAttribute("currentUser",currentUser);
        }
        return "index";
    }


}
