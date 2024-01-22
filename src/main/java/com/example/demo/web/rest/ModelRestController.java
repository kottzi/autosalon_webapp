package com.example.demo.web.rest;

import com.example.demo.dtos.model.AddModelDto;
import com.example.demo.dtos.model.ModelDto;
import com.example.demo.dtos.model.UpdateModelDto;
import com.example.demo.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/models")
public class ModelRestController {
    private ModelService modelService;
    @Autowired
    public void setModelService(ModelService modelService) {this.modelService = modelService;}

    @GetMapping
    List<ModelDto> findAllModels() {return modelService.findAllModels();}

    @GetMapping("/{id}")
    ModelDto findModelById(@PathVariable UUID id) {
        return modelService.findModelById(id);
    }

    @PostMapping
    void addModel(@RequestBody AddModelDto addModelDto) {modelService.addModel(addModelDto);}

    @PutMapping
    void updateModel(@RequestBody UpdateModelDto updateModelDto) {modelService.updateModel(updateModelDto);}

    @DeleteMapping
    void deleteAllModels() {modelService.deleteAllModels();}
    @DeleteMapping("/{id}")
    void deleteModel(@PathVariable UUID id) {modelService.deleteModelById(id);}
}
