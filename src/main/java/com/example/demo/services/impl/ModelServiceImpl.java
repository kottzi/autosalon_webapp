package com.example.demo.services.impl;

import com.example.demo.dtos.brand.BrandDto;
import com.example.demo.dtos.model.AddModelDto;
import com.example.demo.dtos.model.ModelDto;
import com.example.demo.dtos.model.UpdateModelDto;
import com.example.demo.models.entities.Brand;
import com.example.demo.models.entities.Model;
import com.example.demo.models.enums.Category;
import com.example.demo.repositories.BrandRepository;
import com.example.demo.repositories.ModelRepository;
import com.example.demo.services.ModelService;
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
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @CacheEvict(cacheNames = "models", allEntries = true)
    @Override
    public void addModel(AddModelDto addModelDto) {
        Model model = modelMapper.map(addModelDto, Model.class);
        Brand brand = brandRepository.findBrandByName(addModelDto.getBrand().getName()).orElseThrow();
        brandRepository.save(brand);

        model.setBrand(brand);
        model.setCreated(LocalDate.now());
        modelRepository.saveAndFlush(model);
    }

    @CacheEvict(cacheNames = "models", allEntries = true)
    @Override
    public void deleteModel(ModelDto modelDto) {
        modelRepository.deleteById(modelDto.getId());
    }

    @CacheEvict(cacheNames = "models", allEntries = true)
    @Override
    public void deleteModelById(UUID id) {
        modelRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "models", allEntries = true)
    @Override
    public void deleteAllModels() {modelRepository.deleteAll();}

    @Cacheable("models")
    @Override
    public List<ModelDto> findAllModels() {
        return modelRepository.findAll().stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public ModelDto findModelById(UUID id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id), ModelDto.class)).orElseThrow();
    }

    @Override
    public ModelDto findModelByName(String name) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findModelByName(name), ModelDto.class)).orElseThrow();
    }

    @Override
    public List<ModelDto> findModelsByCategory(Category category) {
        return modelRepository.findModelsByCategory(category).stream().map((s) ->
                modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }

    @CacheEvict(cacheNames = "models", allEntries = true)
    @Override
    public void updateModel(UpdateModelDto updateModelDto) {
        Optional<Model> optionalModel = modelRepository.findById(updateModelDto.getId());
        if (optionalModel.isPresent()) {
            Model model = optionalModel.get();
            LocalDate created = model.getCreated();
            model = modelMapper.map(updateModelDto, Model.class);

            Brand brand = brandRepository.findBrandByName(updateModelDto.getBrand().getName()).orElseThrow();
            brandRepository.save(brand);

            model.setBrand(brand);
            model.setCreated(created);
            model.setModified(LocalDate.now());
            modelRepository.saveAndFlush(model);
        }
    }
}
