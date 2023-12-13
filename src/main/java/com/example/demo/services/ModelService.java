package com.example.demo.services;


import com.example.demo.dtos.add.AddModelDto;
import com.example.demo.dtos.all.ShowAllModelsDto;
import com.example.demo.dtos.ModelDto;
import com.example.demo.dtos.details.ShowDetailsModelsDto;
import com.example.demo.models.enums.Category;

import java.util.List;
import java.util.UUID;

public interface ModelService {
    void createModel(ModelDto modelDto);
    void addModel(AddModelDto modelDto);

    void deleteModel(ModelDto modelDto);
    void deleteModelById(UUID id);
    void deleteAllModels();

    List<ModelDto> findAllModels();
    ModelDto findModelById(UUID id);

    List<ShowAllModelsDto> findModelByCategory(Category category);
    ShowDetailsModelsDto findModelByName(String name);
}
