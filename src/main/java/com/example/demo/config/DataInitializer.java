package com.example.demo.config;

import com.example.demo.services.dtos.*;
import com.example.demo.constants.Category;
import com.example.demo.constants.Engine;
import com.example.demo.constants.Role;
import com.example.demo.constants.Transmission;
import com.example.demo.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRoleService userRoleService;
    private final ModelService modelService;
    private final UserService userService;
    private final BrandService brandService;
    private final OfferService offerService;

    public DataInitializer(UserRoleService userRoleService, ModelService modelService, UserService userService, BrandService brandService, OfferService offerService) {
        this.userRoleService = userRoleService;
        this.modelService = modelService;
        this.userService = userService;
        this.brandService = brandService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {seedData();}

    private void seedData() throws IOException {

        UserRoleDto role1 = new UserRoleDto(UUID.randomUUID(), Role.ADMIN);
        UserRoleDto role2 = new UserRoleDto(UUID.randomUUID(), Role.USER);
        role1 = userRoleService.create(role1);
        role2 = userRoleService.create(role2);

        UserDto user1 = new UserDto(UUID.randomUUID(), "kottzi", "1234", "Denis", "Levshenko", true, "https://github.com/kottzi", LocalDate.now(), LocalDate.now(), role1);
        UserDto user2 = new UserDto(UUID.randomUUID(), "Sealex", "1234", "Vladimir", "Vasyliev", true, "https://github.com/silentmiver4", LocalDate.now(), LocalDate.now(), role2);
        user1 = userService.create(user1);
        user2 = userService.create(user2);

        BrandDto brand1 = new BrandDto(UUID.randomUUID(), "BMW", LocalDate.now(), LocalDate.now());
        BrandDto brand2 = new BrandDto(UUID.randomUUID(), "Mercedes", LocalDate.now(), LocalDate.now());
        brand1 = brandService.create(brand1);
        brand2 = brandService.create(brand2);

        ModelDto model1 = new ModelDto(UUID.randomUUID(), "X6", Category.CAR, "https://bmw.com/x6", 2018, 2023, LocalDate.now(), LocalDate.now(), brand1);
        ModelDto model2 = new ModelDto(UUID.randomUUID(), "AMG", Category.CAR, "https://mercedes.com/AMG", 2018, 2023, LocalDate.now(), LocalDate.now(), brand2);
        model1 = modelService.create(model1);
        model2 = modelService.create(model2);

        OfferDto offer1 = new OfferDto(UUID.randomUUID(), "BMW is so good", Engine.GASOLIN, "https://bmw.com/offer", 3000, 100000, Transmission.AUTOMATIC, 2018, LocalDate.now(), LocalDate.now(), model1, user1);
        OfferDto offer2 = new OfferDto(UUID.randomUUID(), "Mercedes is so good", Engine.GASOLIN, "https://mercedes.com/offer", 228, 30000, Transmission.AUTOMATIC, 2018, LocalDate.now(), LocalDate.now(), model2, user2);
        offer1 = offerService.create(offer1);
        offer2 = offerService.create(offer2);

        userService.deleteById(UUID.randomUUID());

        System.out.println(offer1);
        System.out.println(offer2);
    }
}

