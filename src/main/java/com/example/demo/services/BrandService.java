package com.example.demo.services;

import com.example.demo.dtos.add.AddBrandDto;
import com.example.demo.dtos.all.ShowAllBrandsDto;
import com.example.demo.dtos.BrandDto;
import com.example.demo.dtos.update.UpdateBrandDto;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    void createBrand(BrandDto brandDto);
    void addBrand(AddBrandDto brandDto);

    void deleteBrand(BrandDto brandDto);
    void deleteBrandById(UUID id);
    void deleteAllBrands();

    List<BrandDto> findAllBrands();
    BrandDto findBrandById(UUID id);

    List<ShowAllBrandsDto> findBrandByName(String name);

    void updateBrand(UpdateBrandDto brandDto);
}