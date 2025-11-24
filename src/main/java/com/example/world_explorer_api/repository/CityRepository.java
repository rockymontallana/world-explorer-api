package com.example.world_explorer_api.repository;

import com.example.world_explorer_api.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByCountrycode(String countryCode);
}