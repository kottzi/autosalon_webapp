package com.example.demo.services.impl;

import com.example.demo.dtos.add.AddBrandDto;
import com.example.demo.dtos.all.ShowAllBrandsDto;
import com.example.demo.dtos.BrandDto;
import com.example.demo.dtos.update.UpdateBrandDto;
import com.example.demo.models.entities.Brand;
import com.example.demo.repositories.BrandRepository;
import com.example.demo.services.BrandService;
import org.hibernate.sql.Update;
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
@EnableCaching
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createBrand(BrandDto brandDto) {
        brandRepository.saveAndFlush(modelMapper.map(brandDto, Brand.class));
    }
    @Override
    public void addBrand(AddBrandDto brandDto) {
        brandRepository.saveAndFlush(modelMapper.map(brandDto, Brand.class));
    }

    @Override
    public void deleteBrand(BrandDto brandDto) {
        brandRepository.deleteById(brandDto.getId());
    }
    @Override
    public void deleteBrandById(UUID id) {
        brandRepository.deleteById(id);
    }
    @Override
    public void deleteAllBrands() {brandRepository.deleteAll();}

    @Override
    public List<BrandDto> findAllBrands() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public BrandDto findBrandById(UUID id) {
        return modelMapper.map(brandRepository.findById(id), BrandDto.class);
    }

    @Override
    public List<ShowAllBrandsDto> findBrandByName(String name) {
        return brandRepository.findBrandByName(name).stream().map((s) ->
                modelMapper.map(s, ShowAllBrandsDto.class)).collect(Collectors.toList());
    }

    @Override
    public void updateBrand(UpdateBrandDto updateBrandDto) {
        Optional<Brand> optionalBrand = brandRepository.findById(updateBrandDto.getId());
        if (optionalBrand.isPresent()) {
            Brand brand = optionalBrand.get();
            brand.setName(updateBrandDto.getName());
            brandRepository.save(brand);
        }
    }
}
