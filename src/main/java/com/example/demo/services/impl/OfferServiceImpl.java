package com.example.demo.services.impl;

import com.example.demo.dtos.offer.AddOfferDto;
import com.example.demo.dtos.offer.OfferDto;
import com.example.demo.dtos.offer.UpdateOfferDto;
import com.example.demo.models.entities.Model;
import com.example.demo.models.entities.Offer;
import com.example.demo.models.entities.User;
import com.example.demo.repositories.ModelRepository;
import com.example.demo.repositories.OfferRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.OfferService;
import com.example.demo.exceptions.OfferNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//@EnableCaching
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @CacheEvict(value = "offers", allEntries = true)
    @Override
    public void addOffer(AddOfferDto addOfferDto) {
        Offer offer = modelMapper.map(addOfferDto, Offer.class);

        Model model = modelRepository.findModelByName(addOfferDto.getModel().getName()).orElseThrow();
        modelRepository.save(model);
        User user = userRepository.findUserByUsername(addOfferDto.getUser().getUsername()).orElseThrow();
        userRepository.save(user);

        offer.setModel(model);
        offer.setUser(user);
        offer.setCreated(LocalDate.now());
        offerRepository.saveAndFlush(offer);
    }

    @CacheEvict(value = "offers", allEntries = true)
    @Override
    public void deleteOffer(OfferDto offerDto) {
        offerRepository.deleteById(offerDto.getId());
    }

    @CacheEvict(value = "offers", allEntries = true)
    @Override
    public void deleteOfferById(UUID id) {
        offerRepository.deleteById(id);
    }

    @CacheEvict(value = "offers", allEntries = true)
    @Override
    public void deleteAllOffers() {offerRepository.deleteAll();}

    @Cacheable("offers")
    @Override
    public List<OfferDto> findAllOffers() {
        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public OfferDto findOfferById(UUID id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id), OfferDto.class)).orElseThrow(() -> new OfferNotFoundException(id));
    }

    @Override
    public List<OfferDto> findOffersByPrice(int price) {
        return offerRepository.findOffersByPrice(price).stream().map((s) ->
                modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferDto> findOffersByPriceBetween(int start, int end) {
        return offerRepository.findOffersByPriceBetween(start, end).stream().map((s) ->
                modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }

    @CacheEvict(value = "offers", allEntries = true)
    @Override
    public void updateOffer(UpdateOfferDto updateOfferDto) {
        Optional<Offer> optionalOffer = offerRepository.findById(updateOfferDto.getId());
        if (optionalOffer.isPresent()) {
            Offer offer = optionalOffer.get();
            LocalDate created = offer.getCreated();
            offer = modelMapper.map(updateOfferDto, Offer.class);

            Model model = modelRepository.findModelByName(updateOfferDto.getModel().getName()).orElseThrow();
            modelRepository.save(model);
            User user = userRepository.findUserByUsername(updateOfferDto.getUser().getUsername()).orElseThrow();
            userRepository.save(user);

            offer.setModel(model);
            offer.setUser(user);
            offer.setCreated(created);
            offer.setModified(LocalDate.now());
            offerRepository.saveAndFlush(offer);
        }
    }
}
