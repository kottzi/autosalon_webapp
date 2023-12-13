package com.example.demo.services.impl;

import com.example.demo.dtos.add.AddOfferDto;
import com.example.demo.dtos.OfferDto;
import com.example.demo.models.entities.Offer;
import com.example.demo.repositories.OfferRepository;
import com.example.demo.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createOffer(OfferDto offerDto) {
        offerRepository.saveAndFlush(modelMapper.map(offerDto, Offer.class));
    }
    @Override
    public void addOffer(AddOfferDto offerDto) {
        offerRepository.saveAndFlush(modelMapper.map(offerDto, Offer.class));
    }

    @Override
    public void deleteOffer(OfferDto offerDto) {
        offerRepository.deleteById(offerDto.getId());
    }
    @Override
    public void deleteOfferById(UUID id) {
        offerRepository.deleteById(id);
    }
    @Override
    public void deleteAllOffers() {offerRepository.deleteAll();}

    @Override
    public List<OfferDto> findAllOffers() {
        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public OfferDto findOfferById(UUID id) {
        return modelMapper.map(offerRepository.findById(id), OfferDto.class);
    }

    @Override
    public OfferDto findOfferByMileageBetween(int start, int end) {
        return modelMapper.map(offerRepository.findOfferByMileageBetween(start, end), OfferDto.class);
    }
}
