package com.example.demo.services.impl;

import com.example.demo.services.dtos.ModelDto;
import com.example.demo.models.Model;
import com.example.demo.repositories.ModelRepository;
import com.example.demo.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    ModelRepository modelRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ModelDto create(ModelDto modelDto) {
        Model s = modelMapper.map(modelDto, Model.class);
        return modelMapper.map(modelRepository.save(s), ModelDto.class);
    }
    @Override
    public ModelDto addModel(ModelDto modelDto) {
        Model s = modelMapper.map(modelDto, Model.class);
        return modelMapper.map(modelRepository.save(s), ModelDto.class);
    }
    @Override
    public void delete(ModelDto modelDto) {
        modelRepository.deleteById(modelDto.getId());
    }
    @Override
    public void deleteById(UUID id) {
        modelRepository.deleteById(id);
    }
    @Override
    public Optional<ModelDto> findById(UUID id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id), ModelDto.class));
    }
    @Override
    public List<ModelDto> getAll() {
        return modelRepository.findAll().stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public ModelDto findModelByNameAndImageURL(String name, String imageURL) {
        return modelMapper.map(modelRepository.findModelByNameAndImageURL(name, imageURL), ModelDto.class);
    }
}
