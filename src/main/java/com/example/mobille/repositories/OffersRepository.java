package com.example.mobille.repositories;

import com.example.mobille.domein.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OffersRepository extends JpaRepository<Offer, String> {

    List<Offer> findAll();
    Optional<Offer>findById(Long id);
}
