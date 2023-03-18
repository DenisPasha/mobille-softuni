package com.example.mobille.serices.impl;

import com.example.mobille.domein.entities.Brand;
import com.example.mobille.repositories.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DBInitService implements CommandLineRunner {
    private final BrandRepository brandRepository;


    public DBInitService(BrandRepository brandRepository) throws FileNotFoundException {
        this.brandRepository = brandRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (this.brandRepository.count() == 0){
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/carBrands.txt"));

            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            List<Brand>brands = new ArrayList<>();
            lines.stream().forEach(line -> {
                Brand brand = new Brand();
                brand.setName(line);
                brand.setCreated(LocalDateTime.now());
                brand.setModified(LocalDateTime.now());
                brands.add(brand);
            });

            this.brandRepository.saveAllAndFlush(brands);
            System.out.println();
        }
    }
}
