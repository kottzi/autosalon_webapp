package com.example.demo.services.impl;

import com.example.demo.services.dtos.BrandDto;
import com.example.demo.models.Brand;
import com.example.demo.repositories.BrandRepository;
import com.example.demo.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public BrandDto create(BrandDto brandDto) {
        Brand s = modelMapper.map(brandDto, Brand.class);
        return modelMapper.map(brandRepository.save(s), BrandDto.class);
    }
    @Override
    public void delete(BrandDto brandDto) {
        brandRepository.deleteById(brandDto.getId());
    }
    @Override
    public void deleteById(UUID id) {
        brandRepository.deleteById(id);
    }
    @Override
    public Optional<BrandDto> findById(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id), BrandDto.class));
    }
    @Override
    public List<BrandDto> getAll() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public BrandDto findBrandByCreated(LocalDate created) {
        return modelMapper.map(brandRepository.findBrandByCreated(created), BrandDto.class);
    }
}
