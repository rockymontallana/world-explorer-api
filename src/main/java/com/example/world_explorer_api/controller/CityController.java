package com.example.world_explorer_api.controller;

import com.example.world_explorer_api.dto.CityDto;
import com.example.world_explorer_api.model.City;
import com.example.world_explorer_api.repository.CityRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<CityDto> getAll() {
        return cityRepository.findAll()
                .stream()
                .map(city -> {
                    CityDto dto = new CityDto();
                    dto.setId(city.getId());
                    dto.setName(city.getName());
                    dto.setCountryCode(city.getCountrycode());
                    dto.setDistrict(city.getDistrict());
                    dto.setPopulation(city.getPopulation());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CityDto getById(@PathVariable Integer id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
        CityDto dto = new CityDto();
        dto.setId(city.getId());
        dto.setName(city.getName());
        dto.setCountryCode(city.getCountrycode());
        dto.setDistrict(city.getDistrict());
        dto.setPopulation(city.getPopulation());
        return dto;
    }

    @PostMapping
    public CityDto create(@RequestBody CityDto dto) {
        City city = new City();
        city.setName(dto.getName());
        city.setCountrycode(dto.getCountryCode());
        city.setDistrict(dto.getDistrict());
        city.setPopulation(dto.getPopulation());
        city = cityRepository.save(city);
        dto.setId(city.getId());
        return dto;
    }

    @PutMapping("/{id}")
    public CityDto update(@PathVariable Integer id, @RequestBody CityDto dto) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
        city.setName(dto.getName());
        city.setCountrycode(dto.getCountryCode());
        city.setDistrict(dto.getDistrict());
        city.setPopulation(dto.getPopulation());
        city = cityRepository.save(city);
        dto.setId(city.getId());
        return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cityRepository.deleteById(id);
    }
}