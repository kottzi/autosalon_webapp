package com.example.demo.web;

import com.example.demo.dtos.add.AddOfferDto;
import com.example.demo.dtos.add.AddOfferDto;
import com.example.demo.services.OfferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private OfferService offerService;
    @Autowired
    public void setOfferService(OfferService offerService) {this.offerService = offerService;}
    @ModelAttribute
    public AddOfferDto initOffer() {return new AddOfferDto();}

    @GetMapping("/add")
    public String createOffer() {return "/offer-add";}
    @GetMapping("/all")
    public String showOffers(Model model) {
        model.addAttribute("showOffers", offerService.findAllOffers());
        return "/offer-all";
    }

    @PostMapping("/add")
    public String createOffer(@Valid AddOfferDto addOfferDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDto", bindingResult);
            return "redirect:/offers/add";
        } else {
            offerService.addOffer(addOfferDto);
            return "redirect:/offers/all";
        }
    }

    @RequestMapping("/deleteAll")
    public String deleteAllOffers() {
        offerService.deleteAllOffers();
        return "redirect:/offers/all";
    }
}
