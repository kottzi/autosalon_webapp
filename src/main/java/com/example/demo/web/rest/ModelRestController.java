package com.example.demo.web.rest;

import com.example.demo.dtos.add.AddModelDto;
import com.example.demo.dtos.ModelDto;
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
    void createModel(@RequestBody AddModelDto modelDto) {modelService.addModel(modelDto);}

    @PutMapping
    void updateModel(@RequestBody AddModelDto modelDto) {modelService.addModel(modelDto);}

    @DeleteMapping("/{id}")
    void deleteModel(@PathVariable UUID id) {modelService.deleteModelById(id);}
}
