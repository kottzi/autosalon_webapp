package com.example.demo.services;

import com.example.demo.dtos.add.AddOfferDto;
import com.example.demo.dtos.OfferDto;

import java.util.List;
import java.util.UUID;

public interface OfferService {
    void createOffer(OfferDto offerDto);
    void addOffer(AddOfferDto offerDto);

    void deleteOffer(OfferDto offerDto);
    void deleteOfferById(UUID id);
    void deleteAllOffers();

    List<OfferDto> findAllOffers();
    OfferDto findOfferById(UUID id);
    OfferDto findOfferByMileageBetween(int start, int end);
}
