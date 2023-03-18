package com.example.mobille.serices.impl;


import com.example.mobille.domein.dtos.service.AddOfferServiceModel;
import com.example.mobille.domein.dtos.service.UpdateOfferServiceModel;
import com.example.mobille.domein.dtos.view.OfferViewModel;
import com.example.mobille.domein.entities.Offer;
import com.example.mobille.domein.entities.User;
import com.example.mobille.repositories.OffersRepository;
import com.example.mobille.serices.OffersService;
import com.example.mobille.serices.UserService;
import com.example.mobille.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OffersServiceImpl implements OffersService {

    private final OffersRepository offersRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;

    public OffersServiceImpl(OffersRepository offersRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService) {
        this.offersRepository = offersRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    public void saveOffer(AddOfferServiceModel serviceModel){
        this.offersRepository.save(mapToOfferEntity(serviceModel));
    }

    private Offer mapToOfferEntity(AddOfferServiceModel serviceModel) {
        Offer offer = new Offer();
        User seller = userService.finbyId(serviceModel.getSellerId());

        offer.setCreated(serviceModel.getCreated());
        offer.setDescription(serviceModel.getDescription());
        offer.setEngine(serviceModel.getEngine());
        offer.setMileage(serviceModel.getMileage());
        offer.setModel(serviceModel.getModel());
        offer.setModified(serviceModel.getModified());
        offer.setPrice(serviceModel.getPrice());
        offer.setYear(serviceModel.getYear());
        offer.setSeller(seller);
        offer.setTransmission(serviceModel.getTransmission());
        offer.setImageUrl(serviceModel.getImageUrl());
        return offer;
    }

    @Override
    public List<OfferViewModel> getAllOffers() {
        List<Offer> all = this.offersRepository.findAll();
        List<OfferViewModel> views = new ArrayList<>();
        for (Offer offer : all) {
           views.add(modelMapper.map(offer, OfferViewModel.class));
        }
        return views;
    }

    @Override
    public void updateOffer(UpdateOfferServiceModel offerUpdateServiceModel) {
        Offer offer = modelMapper.map(offerUpdateServiceModel, Offer.class);
        offersRepository.save(offer);
    }

    @Override
    public Optional<Offer> getOfferById(Long id) {
        return offersRepository.findById(id);
    }

    @Override
    public void deleteOffer(Long id) {
        this.offersRepository.delete(offersRepository.findById(id).get());
    }
}
