package com.example.demo.utils.validation;

import com.example.demo.repositories.ModelRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueModelNameValidator implements ConstraintValidator<UniqueModelName, String> {

    private ModelRepository modelRepository;
    @Autowired
    public UniqueModelNameValidator(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return modelRepository.findModelByName(name).isEmpty();
    }

}