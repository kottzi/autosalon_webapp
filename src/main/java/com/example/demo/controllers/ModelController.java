package com.example.demo.controllers;

import com.example.demo.controllers.exceptions.ModelNotFoundException;
import com.example.demo.services.dtos.ModelDto;
import com.example.demo.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/models")
public class ModelController {
    private ModelService modelService;
    @Autowired
    public void setModelService(ModelService modelService) {this.modelService = modelService;}

    @GetMapping
    Iterable<ModelDto> all() {return modelService.getAll();}

    @GetMapping("/{id}")
    ModelDto one(@PathVariable UUID id) throws Throwable {
        return (ModelDto) modelService.findById(id).orElseThrow(() -> new ModelNotFoundException(id));
    }

    @PostMapping
    ModelDto createModel(@RequestBody ModelDto modelDto) {return modelService.create(modelDto);}

    @PutMapping
    ModelDto updateModel(@RequestBody ModelDto modelDto) {return modelService.create(modelDto);}

    @DeleteMapping("/{id}")
    void deleteModel(@PathVariable UUID id) {modelService.deleteById(id);}
}
