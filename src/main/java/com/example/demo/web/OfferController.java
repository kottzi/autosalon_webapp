package com.example.demo.web;

import com.example.demo.dtos.brand.BrandDto;
import com.example.demo.dtos.model.ModelDto;
import com.example.demo.dtos.offer.OfferDto;
import com.example.demo.dtos.offer.AddOfferDto;
import com.example.demo.dtos.offer.UpdateOfferDto;
import com.example.demo.dtos.user.UserDto;
import com.example.demo.models.entities.Offer;
import com.example.demo.services.BrandService;
import com.example.demo.services.ModelService;
import com.example.demo.services.OfferService;
import com.example.demo.services.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private OfferService offerService;
    private ModelService modelService;
    private UserService userService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @ModelAttribute("addOffer")
    public AddOfferDto initOffer() {
        return new AddOfferDto();
    }
    @ModelAttribute("models")
    List<ModelDto> findAllModels() {return modelService.findAllModels();}
    @ModelAttribute("users")
    List<UserDto> findAllUsers() {return userService.findAllUsers();}

    @GetMapping("/add")
    public String addOffer() {return "/offer-add";}
    @GetMapping("/all")
    public String showOffers(Model model, Principal principal) {
        model.addAttribute("showOffers", offerService.findAllOffers());

        LOG.log(Level.INFO, String.format("Show all offers for %s",principal.getName()));
        return "/offer-all";
    }

    @PostMapping("/add")
    public String addOffer(AddOfferDto addOfferDto, Principal principal, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDto);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDto", bindingResult);
//            return "redirect:/offers/add";
//        }
        offerService.addOffer(addOfferDto);

        LOG.log(Level.INFO, String.format("Add a new offer by %s", principal.getName()));
        return "redirect:/offers/all";
    }

    @RequestMapping("/deleteAll")
    public String deleteAllOffers() {
        offerService.deleteAllOffers();
        return "redirect:/offers/all";
    }

    @GetMapping("/update/{id}")
    public String updateOffer(@PathVariable UUID id, Model model) {
        OfferDto offerDto = offerService.findOfferById(id);
        model.addAttribute("updateOffer", offerDto);
        return "/offer-update";
    }

    @PostMapping("/update")
    public String updateOffer(@ModelAttribute UpdateOfferDto updateOfferDto) {
        offerService.updateOffer(updateOfferDto);
        return "redirect:/offers/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteOffer(@PathVariable UUID id, Principal principal) {
        offerService.deleteOfferById(id);

        LOG.log(Level.INFO, String.format("Delete an offer by %s", principal.getName()));
        return "redirect:/offers/all";
    }

    @GetMapping("/details/{id}")
    public String showOfferDetails(@PathVariable UUID id, Model model) {
        OfferDto offerDto = offerService.findOfferById(id);
        model.addAttribute("offer", offerDto);
        return "/offer-details";
    }

    // Setter Injection
    @Autowired
    public void setOfferService(OfferService offerService) {this.offerService = offerService;}
    @Autowired
    public void setModelService(ModelService modelService) {this.modelService = modelService;}
    @Autowired
    public void setUserService(UserService userService) {this.userService = userService;}
}
