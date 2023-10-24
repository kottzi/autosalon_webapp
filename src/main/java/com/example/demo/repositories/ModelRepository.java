package com.example.demo.repositories;

import com.example.demo.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {
    Model findModelByNameAndImageURL(String name, String imageURL);
}
