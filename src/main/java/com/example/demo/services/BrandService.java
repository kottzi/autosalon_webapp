package com.example.demo.services;

import com.example.demo.services.dtos.BrandDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {
    BrandDto create(BrandDto brandDto);
    void delete(BrandDto brandDto);
    void deleteById(UUID id);
    Optional<BrandDto> findById(UUID id);
    List<BrandDto> getAll();
    BrandDto findBrandByCreated(LocalDate created);
}