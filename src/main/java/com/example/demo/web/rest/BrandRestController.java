package com.example.demo.web.rest;

import com.example.demo.dtos.add.AddBrandDto;
import com.example.demo.dtos.BrandDto;
import com.example.demo.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/brands")
public class BrandRestController {
    private BrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {this.brandService = brandService;}

    @GetMapping
    List<BrandDto> findAllBrands() {return brandService.findAllBrands();}

    @GetMapping("/{id}")
    BrandDto findBrandById(@PathVariable UUID id) {
        return brandService.findBrandById(id);
    }

    @PostMapping
    void createBrand(@RequestBody AddBrandDto brandDto) {brandService.addBrand(brandDto);}

    @PutMapping
    void updateBrand(@RequestBody AddBrandDto brandDto) {brandService.addBrand(brandDto);}

    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {brandService.deleteBrandById(id);}
}
