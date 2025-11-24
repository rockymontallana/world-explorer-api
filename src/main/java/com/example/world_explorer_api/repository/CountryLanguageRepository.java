package com.example.world_explorer_api.repository;

import com.example.world_explorer_api.model.CountryLanguage;
import com.example.world_explorer_api.model.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {
}