package com.example.demo.services.impl;

import com.example.demo.services.dtos.OfferDto;
import com.example.demo.models.Offer;
import com.example.demo.repositories.OfferRepository;
import com.example.demo.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    OfferRepository offerRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public OfferDto create(OfferDto offerDto) {
        Offer s = modelMapper.map(offerDto, Offer.class);
        return modelMapper.map(offerRepository.save(s), OfferDto.class);
    }
    @Override
    public void delete(OfferDto offerDto) {
        offerRepository.deleteById(offerDto.getId());
    }
    @Override
    public void deleteById(UUID id) {
        offerRepository.deleteById(id);
    }
    @Override
    public Optional<OfferDto> findById(UUID id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id), OfferDto.class));
    }
    @Override
    public List<OfferDto> getAll() {
        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public OfferDto findOfferByMileageBetween(int start, int end) {
        return modelMapper.map(offerRepository.findOfferByMileageBetween(start, end), OfferDto.class);
    }
}
