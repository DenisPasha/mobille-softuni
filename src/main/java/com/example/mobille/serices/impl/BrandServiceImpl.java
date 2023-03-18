package com.example.mobille.serices.impl;

import com.example.mobille.domein.entities.Brand;
import com.example.mobille.repositories.BrandRepository;
import com.example.mobille.serices.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }
}
