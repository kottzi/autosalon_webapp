package com.example.demo.controllers;

import com.example.demo.controllers.exceptions.OfferNotFoundException;
import com.example.demo.services.dtos.OfferDto;
import com.example.demo.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/offers")
public class OfferController {
    private OfferService offerService;
    @Autowired
    public void setOfferService(OfferService offerService) {this.offerService = offerService;}

    @GetMapping
    Iterable<OfferDto> all() {return offerService.getAll();}

    @GetMapping("/{id}")
    OfferDto one(@PathVariable UUID id) throws Throwable {
        return (OfferDto) offerService.findById(id).orElseThrow(() -> new OfferNotFoundException(id));
    }

    @PostMapping
    OfferDto updateOffer(@RequestBody OfferDto offerDto) {return offerService.create(offerDto);}

    @PutMapping
    OfferDto newOffer(@RequestBody OfferDto offerDto) {return offerService.create(offerDto);}

    @DeleteMapping("/{id}")
    void deleteOffer(@PathVariable UUID id) {offerService.deleteById(id);}
}
