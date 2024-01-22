package com.example.demo.services;


import com.example.demo.dtos.model.AddModelDto;
import com.example.demo.dtos.model.ModelDto;
import com.example.demo.dtos.model.UpdateModelDto;
import com.example.demo.models.enums.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModelService {
    void addModel(AddModelDto addModelDto);

    void deleteModel(ModelDto modelDto);
    void deleteModelById(UUID id);
    void deleteAllModels();

    List<ModelDto> findAllModels();
    ModelDto findModelById(UUID id);
    ModelDto findModelByName(String name);
    List<ModelDto> findModelsByCategory(Category category);

    void updateModel(UpdateModelDto updateModelDto);
}
