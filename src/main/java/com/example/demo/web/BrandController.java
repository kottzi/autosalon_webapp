package com.example.demo.web;

import com.example.demo.dtos.brand.BrandDto;
import com.example.demo.dtos.brand.AddBrandDto;
import com.example.demo.dtos.brand.UpdateBrandDto;
import com.example.demo.services.BrandService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private BrandService brandService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @ModelAttribute("addBrandDto")
    public AddBrandDto initBrand() {return new AddBrandDto();}

    @GetMapping("/add")
    public String addBrand() {return "/brand-add";}
    @GetMapping("/all")
    public String showBrands(Model model, Principal principal) {
        model.addAttribute("showBrands", brandService.findAllBrands());

        LOG.log(Level.INFO, String.format("Show all brands for %s",
                principal.getName()));
        return "/brand-all";
    }

    @PostMapping("/add")
    public String addBrand(@Valid AddBrandDto addBrandDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addBrandDto", addBrandDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addBrandDto", bindingResult);
            return "redirect:/brands/add";
        }
        brandService.addBrand(addBrandDto);

        LOG.log(Level.INFO, String.format("Add a new brand with name (%s) by %s",
                brandService.findBrandByName(addBrandDto.getName()), principal.getName()));
        return "redirect:/brands/all";
    }

    @RequestMapping("/deleteAll")
    public String deleteAllBrands(Principal principal) {
        brandService.deleteAllBrands();

        LOG.log(Level.INFO, String.format("Deleted all brands by %s",
                principal.getName()));
        return "redirect:/brands/all";
    }

    @RequestMapping("/search")
    public String searchModels(@RequestParam(name = "name", required = false) String name, Model model) {
        List<BrandDto> searchResults = brandService.findBrandsByName(name);
        model.addAttribute("searchResults", searchResults);
        return "/brand-search";
    }

    @GetMapping("/update/{id}")
    public String updateBrand(@PathVariable UUID id, Model model) {
        BrandDto brandDto = brandService.findBrandById(id);
        model.addAttribute("updateBrand", brandDto);
        return "/brand-update";
    }

    @PostMapping("/update")
    public String updateBrand(@ModelAttribute UpdateBrandDto updateBrandDto, Principal principal) {
        brandService.updateBrand(updateBrandDto);

        LOG.log(Level.INFO, String.format("Update a brand (%s) by %s",
                brandService.findBrandByName(updateBrandDto.getName()), principal.getName()));
        return "redirect:/brands/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBrand(@PathVariable UUID id, Principal principal) {
        brandService.deleteBrandById(id);

        LOG.log(Level.INFO, String.format("Delete a brand with name (%s) by %s",
                brandService.findBrandById(id).getName(), principal.getName()));
        return "redirect:/brands/all";
    }

    // Setter Injection
    @Autowired
    public void setBrandService(BrandService brandService) {this.brandService = brandService;}
}