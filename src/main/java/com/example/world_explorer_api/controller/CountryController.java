package com.example.world_explorer_api.controller;

import com.example.world_explorer_api.dto.CountryDto;
import com.example.world_explorer_api.model.Country;
import com.example.world_explorer_api.repository.CountryRepository;
import com.example.world_explorer_api.service.CountryMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // 1. List (GET)
    @GetMapping
    public List<CountryDto> getAll() {
        return countryRepository.findAll()
                .stream()
                .map(CountryMapper::toDto)
                .collect(Collectors.toList());
    }

    // 2. Detail (GET by CODE)
    @GetMapping("/{code}")
    public CountryDto getByCode(@PathVariable String code) {
        return countryRepository.findById(code)
                .map(CountryMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    // 3. Create (POST)
    @PostMapping
    public CountryDto createCountry(@RequestBody CountryDto dto) {
        Country country = CountryMapper.toEntity(dto);
        Country saved = countryRepository.save(country); // ensure 'code' is unique
        return CountryMapper.toDto(saved);
    }

    // 4. Update (PUT)
    @PutMapping("/{code}")
    public CountryDto updateCountry(@PathVariable String code, @RequestBody CountryDto dto) {
        Country country = countryRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        country.setName(dto.getName());
        country.setContinent(dto.getContinent());
        country.setRegion(dto.getRegion());
        country.setPopulation(dto.getPopulation());
        Country updated = countryRepository.save(country);
        return CountryMapper.toDto(updated);
    }

    // 5. Delete (DELETE)
    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        countryRepository.deleteById(code);
    }
}