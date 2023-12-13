package com.example.demo.repositories;

import com.example.demo.models.entities.Brand;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
    @Transactional
    @Modifying
    List<?> findBrandByName(String name);
}
