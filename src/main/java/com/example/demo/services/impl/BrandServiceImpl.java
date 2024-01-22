package com.example.demo.services.impl;

import com.example.demo.dtos.brand.AddBrandDto;
import com.example.demo.dtos.brand.BrandDto;
import com.example.demo.dtos.brand.UpdateBrandDto;
import com.example.demo.models.entities.Brand;
import com.example.demo.repositories.BrandRepository;
import com.example.demo.services.BrandService;
import com.example.demo.exceptions.BrandNotFoundException;
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
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @CacheEvict(value = "brands", allEntries = true)
    @Override
    public void addBrand(AddBrandDto addBrandDto) {
        Brand brand = modelMapper.map(addBrandDto, Brand.class);

        brand.setCreated(LocalDate.now());
        brandRepository.saveAndFlush(brand);
    }

    @CacheEvict(value = "brands", allEntries = true)
    @Override
    public void deleteBrand(BrandDto brandDto) {
        brandRepository.deleteById(brandDto.getId());
    }

    @CacheEvict(value = "brands", allEntries = true)
    @Override
    public void deleteBrandById(UUID id) {
        brandRepository.deleteById(id);
    }

    @CacheEvict(value = "brands", allEntries = true)
    @Override
    public void deleteAllBrands() {brandRepository.deleteAll();}

    @Cacheable("brands")
    @Override
    public List<BrandDto> findAllBrands() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public BrandDto findBrandById(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id), BrandDto.class)).orElseThrow(() -> new BrandNotFoundException(id));
    }

    @Override
    public BrandDto findBrandByName(String name) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findBrandByName(name), BrandDto.class)).orElseThrow();
    }

    @Override
    public List<BrandDto> findBrandsByName(String name) {
        return brandRepository.findBrandsByName(name).stream().map((s) ->
                modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @CacheEvict(value = "brands", allEntries = true)
    @Override
    public void updateBrand(UpdateBrandDto updateBrandDto) {
        Optional<Brand> optionalBrand = brandRepository.findById(updateBrandDto.getId());
        if (optionalBrand.isPresent()) {
            Brand brand = optionalBrand.get();

            brand.setName(updateBrandDto.getName());
            brand.setModified(LocalDate.now());
            brandRepository.saveAndFlush(brand);
        }
    }
}
