package com.example.demo.web;

import com.example.demo.dtos.add.AddBrandDto;
import com.example.demo.dtos.all.ShowAllBrandsDto;
import com.example.demo.services.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private BrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {this.brandService = brandService;}
    @ModelAttribute
    public AddBrandDto initBrand() {return new AddBrandDto();}

    @GetMapping("/add")
    public String createBrand() {return "/brand-add";}
    @GetMapping("/all")
    public String showBrands(Model model) {
        model.addAttribute("showBrands", brandService.findAllBrands());
        return "/brand-all";
    }

    @PostMapping("/add")
    public String createBrand(@Valid AddBrandDto addBrandDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("addBrandDto", addBrandDto);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addBrandDto", bindingResult);
//            return "redirect:/brands/add";
//        } else {
            brandService.addBrand(addBrandDto);
            return "redirect:/brands/all";
//        }
    }

    @RequestMapping("/deleteAll")
    public String deleteAllBrands() {
        brandService.deleteAllBrands();
        return "redirect:/brands/all";
    }

    @RequestMapping("/search")
    public String searchModels(@RequestParam(name = "name", required = false) String name, Model model) {
        List<ShowAllBrandsDto> searchResults = brandService.findBrandByName(name);
        model.addAttribute("searchResults", searchResults);
        return "/brand-search";
    }
}