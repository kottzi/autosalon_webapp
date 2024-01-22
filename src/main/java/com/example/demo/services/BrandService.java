package com.example.demo.services;

import com.example.demo.dtos.brand.AddBrandDto;
import com.example.demo.dtos.brand.BrandDto;
import com.example.demo.dtos.brand.UpdateBrandDto;
import com.example.demo.models.entities.Brand;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {
    void addBrand(AddBrandDto addBrandDto);

    void deleteBrand(BrandDto brandDto);
    void deleteBrandById(UUID id);
    void deleteAllBrands();

    List<BrandDto> findAllBrands();
    BrandDto findBrandById(UUID id);
    BrandDto findBrandByName(String name);
    List<BrandDto> findBrandsByName(String name);

    void updateBrand(UpdateBrandDto updateBrandDto);
}