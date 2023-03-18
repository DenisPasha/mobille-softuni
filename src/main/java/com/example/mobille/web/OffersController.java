package com.example.mobille.web;

import com.example.mobille.domein.dtos.binding.OfferAddBindingModel;
import com.example.mobille.domein.dtos.binding.OfferUpdateBindingModel;
import com.example.mobille.domein.dtos.service.AddOfferServiceModel;
import com.example.mobille.domein.dtos.service.UpdateOfferServiceModel;
import com.example.mobille.domein.dtos.view.OfferViewModel;
import com.example.mobille.domein.entities.Brand;
import com.example.mobille.domein.entities.enums.Engine;
import com.example.mobille.domein.entities.enums.Transmission;
import com.example.mobille.serices.BrandService;
import com.example.mobille.serices.OffersService;
import com.example.mobille.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OffersController {
    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel() {
        return new OfferAddBindingModel();
    }

    private final BrandService brandService;
    private final CurrentUser currentUser;
    private final OffersService offersService;
    private final ModelMapper modelMapper;

    public OffersController(BrandService brandService, CurrentUser currentUser, OffersService offersService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.currentUser = currentUser;
        this.offersService = offersService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("offers/add")
    public String getOffers(Model model) {
        List<Brand> brandsAndTheirModels = brandService.getAllBrands();

        getEnginesAndTransmissionTypes(model);
        model.addAttribute("brandsAndTheirModels", brandsAndTheirModels);
        model.addAttribute("currentUser", currentUser);

        return "offer-add";
    }

    @PostMapping("offers/add")
    public String addOffer(@Valid OfferAddBindingModel offerAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        offerAddBindingModel.setCreated(LocalDateTime.now());
        offerAddBindingModel.setModified(LocalDateTime.now());
        offerAddBindingModel.setSellerId(currentUser.getId());

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerAddBindingModel", offerAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);
            return "redirect:add";
        }
        AddOfferServiceModel serviceModel = modelMapper.map(offerAddBindingModel, AddOfferServiceModel.class);
        offersService.saveOffer(serviceModel);
        return "redirect:/";
    }

    @GetMapping("offers/all")
    public String getAllOffers(Model model) {
        model.addAttribute("currentUser",currentUser);
        model.addAttribute("offers", offersService.getAllOffers());
        return "offers";
    }

    @GetMapping("offers/details/{id}")
    public String getAllOffersDetails(Model model, @PathVariable Long id) {

        getCurentOffer(model, id);
        return "details";
    }


    @GetMapping("offers/update/{id}")
    public String getUpdateOffer(@PathVariable Long id, Model model , RedirectAttributes redirectAttributes ) {
        OfferViewModel offer = offersService.getAllOffers().stream().filter(offerViewModel -> offerViewModel.getId().equals(id)).findFirst().get();

            if (currentUser.getUsername() == null || !currentUser.getId().equals(offer.getSeller().getId()) ){
                redirectAttributes.addFlashAttribute("userNotQualified",true);
                return "redirect:/";
            }

        getEnginesAndTransmissionTypes(model);
        model.addAttribute("currentOffer",offer);
        return "update";
    }

    @PostMapping("offers/update/{id}")
    public String postUpdate(@Valid OfferUpdateBindingModel offerUpdateBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        addStaticData(offerUpdateBindingModel);

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("currentOffer", offerUpdateBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.currentOffer", bindingResult);
            return "redirect:{id}";
        }
        offersService.updateOffer(modelMapper.map(offerUpdateBindingModel, UpdateOfferServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("offers/delete/{id}")
    public String deleteOffer(@PathVariable Long id , RedirectAttributes redirectAttributes){
        if (offersService.getOfferById(id).get().getSeller().getId().equals(currentUser.getId())) {
            offersService.deleteOffer(id);
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("userNotQualified",true);
        return "redirect:/";

    }

    private void addStaticData(OfferUpdateBindingModel offerUpdateBindingModel) {
        offerUpdateBindingModel.setModified(LocalDateTime.now());
        offerUpdateBindingModel.setSellerId(currentUser.getId());
        offerUpdateBindingModel.setCreated(offersService.getOfferById(offerUpdateBindingModel.getId()).get().getCreated());
    }


    private static void getEnginesAndTransmissionTypes(Model model) {
        Engine[] engines = Engine.values();
        Transmission[] transmissions = Transmission.values();
        model.addAttribute("engines", engines);
        model.addAttribute("transmissions", transmissions);
    }

    private void getCurentOffer(Model model, Long id) {
        model.addAttribute("currentOffer", offersService.getAllOffers()
                .stream()
                .filter(offerViewModel -> offerViewModel.getId().equals(id))
                .findFirst()
                .get());
    }
}
