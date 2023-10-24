package com.example.demo.services;


import com.example.demo.models.Model;
import com.example.demo.services.dtos.ModelDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelService {
    ModelDto create(ModelDto modelDto);
    void delete(ModelDto modelDto);
    void deleteById(UUID id);
    Optional<ModelDto> findById(UUID id);
    List<ModelDto> getAll();
    ModelDto findModelByNameAndImageURL(String name, String imageURL);
}
