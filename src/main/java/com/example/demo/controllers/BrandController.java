package com.example.demo.controllers;

import com.example.demo.controllers.exceptions.BrandNotFoundException;
import com.example.demo.services.dtos.BrandDto;
import com.example.demo.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/brands")
public class BrandController {
    private BrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {this.brandService = brandService;}

    @GetMapping
    Iterable<BrandDto> all() {return brandService.getAll();}

    @GetMapping("/{id}")
    BrandDto one(@PathVariable UUID id) throws Throwable {
        return (BrandDto) brandService.findById(id).orElseThrow(() -> new BrandNotFoundException(id));
    }

    @PostMapping
    BrandDto newBrand(@RequestBody BrandDto brandDto) {return brandService.create(brandDto);}

    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {brandService.deleteById(id);}
}
