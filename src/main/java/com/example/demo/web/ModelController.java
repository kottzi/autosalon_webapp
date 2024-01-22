package com.example.demo.web;

import com.example.demo.dtos.brand.BrandDto;
import com.example.demo.dtos.model.ModelDto;
import com.example.demo.dtos.model.AddModelDto;
import com.example.demo.dtos.model.UpdateModelDto;
import com.example.demo.models.enums.Category;
import com.example.demo.services.BrandService;
import com.example.demo.services.ModelService;
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
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/models")
public class ModelController {
    private ModelService modelService;
    private BrandService brandService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @ModelAttribute("addModel")
    public AddModelDto initModel() {
        return new AddModelDto();
    }
    @ModelAttribute("brands")
    List<BrandDto> findAllBrands() {return brandService.findAllBrands();}

    @GetMapping("/add")
    public String addModel() {
        return "/model-add";
    }

    @GetMapping("/all")
    public String showModels(Model model, Principal principal) {
        model.addAttribute("showModels", modelService.findAllModels());

        LOG.log(Level.INFO, String.format("Show all models for %s",
                principal.getName()));
        return "/model-all";
    }

    @PostMapping("/add")
    public String addModel(@Valid AddModelDto addModelDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addModelDto", addModelDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addModelDto", bindingResult);
            return "redirect:/models/add";
        }
        modelService.addModel(addModelDto);

        LOG.log(Level.INFO, String.format("Add a new model with name (%s) by %s",
                modelService.findModelByName(addModelDto.getName()), principal.getName()));
        return "redirect:/models/all";
    }

    @RequestMapping("/deleteAll")
    public String deleteAllModels(Principal principal) {
        modelService.deleteAllModels();

        LOG.log(Level.INFO, String.format("Deleted all models by %s",
                principal.getName()));
        return "redirect:/models/all";
    }

    @RequestMapping("/search")
    public String searchModels(@RequestParam(name = "category", required = false) Category category, Model model) {
        List<ModelDto> searchResults = modelService.findModelsByCategory(category);
        model.addAttribute("searchResults", searchResults);
        return "/model-search";
    }

    @GetMapping("/update/{id}")
    public String updateModel(@PathVariable UUID id, Model model) {
        ModelDto modelDto = modelService.findModelById(id);
        model.addAttribute("updateModel", modelDto);
        return "/model-update";
    }

    @PostMapping("/update")
    public String updateModel(@ModelAttribute UpdateModelDto updateModelDto, Principal principal) {
        modelService.updateModel(updateModelDto);

        LOG.log(Level.INFO, String.format("Update a model (%s) by %s",
                modelService.findModelByName(updateModelDto.getName()), principal.getName()));
        return "redirect:/models/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteModel(@PathVariable UUID id, Principal principal) {
        modelService.deleteModelById(id);

        LOG.log(Level.INFO, String.format("Delete a model with name (%s) by %s",
                modelService.findModelById(id).getName(), principal.getName()));
        return "redirect:/models/all";
    }

    @GetMapping("/details/{id}")
    public String showModelDetails(@PathVariable UUID id, Model model, Principal principal) {
        ModelDto modelDto = modelService.findModelById(id);
        model.addAttribute("model", modelDto);

        return "/model-details";
    }

    // Setter Injection
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
}
