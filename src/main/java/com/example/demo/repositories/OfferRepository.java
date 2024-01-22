package com.example.demo.repositories;

import com.example.demo.dtos.offer.OfferDto;
import com.example.demo.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {
    List<Offer> findOffersByPrice(int price);
    List<Offer> findOffersByPriceBetween(int start, int end);
}
