package com.example.mobille.web;

import com.example.mobille.domein.entities.Brand;
import com.example.mobille.serices.BrandService;
import com.example.mobille.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BrandsController {
    private final BrandService brandService;
    private final CurrentUser currentUser;

    public BrandsController(BrandService brandService, CurrentUser currentUser) {
        this.brandService = brandService;
        this.currentUser = currentUser;
    }



    @GetMapping("/brands/all")
    public String getBrands(Model model ){
        List<Brand> allBrands = brandService.getAllBrands();
        model.addAttribute("brands" , allBrands);
        model.addAttribute("currentUser",currentUser);

        return "brands";
    }
}

