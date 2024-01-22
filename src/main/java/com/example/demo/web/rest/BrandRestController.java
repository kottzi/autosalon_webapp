package com.example.demo.web.rest;

import com.example.demo.dtos.brand.AddBrandDto;
import com.example.demo.dtos.brand.BrandDto;
import com.example.demo.dtos.brand.UpdateBrandDto;
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
    void addBrand(@RequestBody AddBrandDto addBrandDto) {brandService.addBrand(addBrandDto);}

    @PutMapping
    void updateBrand(@RequestBody UpdateBrandDto updateBrandDtoe) {brandService.updateBrand(updateBrandDtoe);}

    @DeleteMapping
    void deleteAllBrands() {brandService.deleteAllBrands();}
    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {brandService.deleteBrandById(id);}
}
