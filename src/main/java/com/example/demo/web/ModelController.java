package com.example.demo.web;

import com.example.demo.dtos.BrandDto;
import com.example.demo.dtos.ModelDto;
import com.example.demo.dtos.add.AddModelDto;
import com.example.demo.dtos.all.ShowAllBrandsDto;
import com.example.demo.dtos.all.ShowAllModelsDto;
import com.example.demo.dtos.update.UpdateBrandDto;
import com.example.demo.dtos.update.UpdateModelDto;
import com.example.demo.models.enums.Category;
import com.example.demo.services.BrandService;
import com.example.demo.services.ModelService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.sql.Update;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/models")
public class ModelController {
    private ModelService modelService;
    private BrandService brandService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @ModelAttribute
    public AddModelDto initModel() {
        return new AddModelDto();
    }
    @ModelAttribute
    public UpdateModelDto updateModelDto() { return new UpdateModelDto(); }
    @ModelAttribute("brands")
    List<BrandDto> findAllBrands() {return brandService.findAllBrands();}

    @GetMapping("/add")
    public String createModel() {
        return "/model-add";
    }

    @GetMapping("/all")
    public String showModels(Model model) {
        model.addAttribute("showModels", modelService.findAllModels());
        return "/model-all";
    }

    @PostMapping("/add")
    public String createModel(@Valid AddModelDto addModelDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addModelDto", addModelDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addModelDto", bindingResult);
            return "redirect:/models/add";
        } else {
            modelService.addModel(addModelDto);
            return "redirect:/models/all";
        }
    }

    @RequestMapping("/deleteAll")
    public String deleteAllModels() {
        modelService.deleteAllModels();
        return "redirect:/models/all";
    }

    @RequestMapping("/search")
    public String searchModels(@RequestParam(name = "category", required = false) Category category, Model model) {
        List<ShowAllModelsDto> searchResults = modelService.findModelByCategory(category);
        model.addAttribute("searchResults", searchResults);
        return "/model-search";
    }

    @RequestMapping("/details/{model-name}")
    public String modelDetails(@PathVariable("model-name") String name, Model model) {
        model.addAttribute("modelDetails", modelService.findModelByName(name));
        return "/model-details";
    }

    @GetMapping("/update/{id}")
    public String updateModel(@PathVariable UUID id, Model model) {
        ModelDto modelDto = modelService.findModelById(id);
        model.addAttribute("updateModel", modelDto);
        return "/model-update";
    }

    @PostMapping("/update")
    public String updateModel(@ModelAttribute UpdateModelDto updateModelDto) {
        modelService.updateModel(updateModelDto);
        return "redirect:/models/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBrand(@PathVariable UUID id) {
        modelService.deleteModelById(id);
        return "redirect:/models/all";
    }
}
