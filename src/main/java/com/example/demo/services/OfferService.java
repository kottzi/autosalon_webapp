package com.example.demo.services;

import com.example.demo.models.Offer;
import com.example.demo.services.dtos.OfferDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferService {
    OfferDto create(OfferDto offerDto);
    void delete(OfferDto offerDto);
    void deleteById(UUID id);
    Optional<OfferDto> findById(UUID id);
    List<OfferDto> getAll();
    OfferDto findOfferByMileageBetween(int start, int end);
}
