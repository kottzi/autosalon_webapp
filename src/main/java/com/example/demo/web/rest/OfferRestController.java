package com.example.demo.web.rest;

import com.example.demo.dtos.add.AddOfferDto;
import com.example.demo.dtos.OfferDto;
import com.example.demo.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/offers")
public class OfferRestController {
    private OfferService offerService;
    @Autowired
    public void setOfferService(OfferService offerService) {this.offerService = offerService;}

    @GetMapping
    List<OfferDto> findAllOffers() {return offerService.findAllOffers();}

    @GetMapping("/{id}")
    OfferDto findOfferById(@PathVariable UUID id) {
        return offerService.findOfferById(id);
    }

    @PostMapping
    void createOffer(@RequestBody AddOfferDto offerDto) {offerService.addOffer(offerDto);}

    @PutMapping
    void updateOffer(@RequestBody AddOfferDto offerDto) {offerService.addOffer(offerDto);}

    @DeleteMapping("/{id}")
    void deleteOffer(@PathVariable UUID id) {offerService.deleteOfferById(id);}
}
