package com.example.demo.repositories;

import com.example.demo.dtos.ModelDto;
import com.example.demo.dtos.details.ShowDetailsModelsDto;
import com.example.demo.models.entities.Model;
import com.example.demo.models.enums.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {
    @Transactional
    @Modifying
    List<?> findModelByCategory(Category category);

    @Transactional
    @Modifying
    List<?> findModelByName(String name);
}
