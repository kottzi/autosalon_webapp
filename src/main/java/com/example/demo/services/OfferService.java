package com.example.demo.services;

import com.example.demo.dtos.offer.AddOfferDto;
import com.example.demo.dtos.offer.OfferDto;
import com.example.demo.dtos.offer.UpdateOfferDto;
import com.example.demo.models.entities.Offer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferService {
    void addOffer(AddOfferDto addOfferDto);

    void deleteOffer(OfferDto offerDto);
    void deleteOfferById(UUID id);
    void deleteAllOffers();

    List<OfferDto> findAllOffers();
    OfferDto findOfferById(UUID id);
    List<OfferDto> findOffersByPrice(int price);
    List<OfferDto> findOffersByPriceBetween(int start, int end);

    void updateOffer(UpdateOfferDto updateOfferDto);
}
