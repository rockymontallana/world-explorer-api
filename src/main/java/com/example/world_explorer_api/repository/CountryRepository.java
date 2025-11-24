package com.example.world_explorer_api.repository;

import com.example.world_explorer_api.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
    // Additional custom queries if needed
}