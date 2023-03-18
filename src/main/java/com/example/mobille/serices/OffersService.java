package com.example.mobille.serices;

import com.example.mobille.domein.dtos.service.AddOfferServiceModel;
import com.example.mobille.domein.dtos.service.UpdateOfferServiceModel;
import com.example.mobille.domein.dtos.view.OfferViewModel;
import com.example.mobille.domein.entities.Offer;

import java.util.List;
import java.util.Optional;

public interface OffersService {
    void saveOffer(AddOfferServiceModel serviceModel);

    List<OfferViewModel> getAllOffers();

    void updateOffer(UpdateOfferServiceModel map);

    Optional<Offer> getOfferById(Long id);

    void deleteOffer(Long id);
}
