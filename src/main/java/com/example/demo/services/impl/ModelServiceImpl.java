package com.example.demo.services.impl;

import com.example.demo.dtos.add.AddModelDto;
import com.example.demo.dtos.all.ShowAllModelsDto;
import com.example.demo.dtos.ModelDto;
import com.example.demo.dtos.details.ShowDetailsModelsDto;
import com.example.demo.dtos.update.UpdateModelDto;
import com.example.demo.models.entities.Model;
import com.example.demo.models.enums.Category;
import com.example.demo.repositories.ModelRepository;
import com.example.demo.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@EnableCaching
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createModel(ModelDto modelDto) {
        modelRepository.saveAndFlush(modelMapper.map(modelDto, Model.class));
    }
    @Override
    public void addModel(AddModelDto modelDto) {
        modelRepository.saveAndFlush(modelMapper.map(modelDto, Model.class));
    }

    @Override
    public void deleteModel(ModelDto modelDto) {
        modelRepository.deleteById(modelDto.getId());
    }
    @Override
    public void deleteModelById(UUID id) {
        modelRepository.deleteById(id);
    }
    @Override
    public void deleteAllModels() {modelRepository.deleteAll();}

    @Override
    public List<ModelDto> findAllModels() {
        return modelRepository.findAll().stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public ModelDto findModelById(UUID id) {
        return modelMapper.map(modelRepository.findById(id), ModelDto.class);
    }

    @Override
    public List<ShowAllModelsDto> findModelByCategory(Category category) {
        return modelRepository.findModelByCategory(category).stream().map((s) ->
                modelMapper.map(s, ShowAllModelsDto.class)).collect(Collectors.toList());
    }

    @Override
    public ShowDetailsModelsDto findModelByName(String name) {
        return modelMapper.map(modelRepository.findModelByName(name), ShowDetailsModelsDto.class);
    }

    @Override
    public void updateModel(UpdateModelDto updateModelDto) {
        Optional<Model> optionalModel = modelRepository.findById(updateModelDto.getId());
        if (optionalModel.isPresent()) {
            Model model = optionalModel.get();
            model.setName(updateModelDto.getName());
            model.setCategory(updateModelDto.getCategory());
            model.setStartYear(updateModelDto.getStartYear());
            modelRepository.save(model);
        }
    }
}
