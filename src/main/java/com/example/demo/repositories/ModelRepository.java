package com.example.demo.repositories;

import com.example.demo.models.entities.Model;
import com.example.demo.models.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {
    Optional<Model> findModelByName(String name);
    List<Model> findModelsByCategory(Category category);
}
