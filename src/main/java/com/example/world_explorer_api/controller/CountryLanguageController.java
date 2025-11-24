package com.example.world_explorer_api.controller;

import com.example.world_explorer_api.dto.CountryLanguageDto;
import com.example.world_explorer_api.model.CountryLanguage;
import com.example.world_explorer_api.model.CountryLanguageId;
import com.example.world_explorer_api.repository.CountryLanguageRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countrylanguages")
public class CountryLanguageController {
    private final CountryLanguageRepository repo;

    public CountryLanguageController(CountryLanguageRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<CountryLanguageDto> getAll() {
        return repo.findAll()
                .stream()
                .map(cl -> {
                    CountryLanguageDto dto = new CountryLanguageDto();
                    dto.setCountryCode(cl.getId().getCountryCode());
                    dto.setLanguage(cl.getId().getLanguage());
                    dto.setIsOfficial(cl.getIsofficial());
                    dto.setPercentage(cl.getPercentage());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{countryCode}/{language}")
    public CountryLanguageDto getById(@PathVariable String countryCode, @PathVariable String language) {
        CountryLanguageId id = new CountryLanguageId();
        id.setCountryCode(countryCode);
        id.setLanguage(language);
        CountryLanguage cl = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        CountryLanguageDto dto = new CountryLanguageDto();
        dto.setCountryCode(cl.getId().getCountryCode());
        dto.setLanguage(cl.getId().getLanguage());
        dto.setIsOfficial(cl.getIsofficial());
        dto.setPercentage(cl.getPercentage());
        return dto;
    }

    @PostMapping
    public CountryLanguageDto create(@RequestBody CountryLanguageDto dto) {
        CountryLanguageId id = new CountryLanguageId();
        id.setCountryCode(dto.getCountryCode());
        id.setLanguage(dto.getLanguage());
        CountryLanguage cl = new CountryLanguage();
        cl.setId(id);
        cl.setIsofficial(dto.getIsOfficial());
        cl.setPercentage(dto.getPercentage());
        cl = repo.save(cl);
        return dto;
    }

    @PutMapping("/{countryCode}/{language}")
    public CountryLanguageDto update(@PathVariable String countryCode, @PathVariable String language,
                                     @RequestBody CountryLanguageDto dto) {
        CountryLanguageId id = new CountryLanguageId();
        id.setCountryCode(countryCode);
        id.setLanguage(language);
        CountryLanguage cl = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        cl.setIsofficial(dto.getIsOfficial());
        cl.setPercentage(dto.getPercentage());
        cl = repo.save(cl);
        return dto;
    }

    @DeleteMapping("/{countryCode}/{language}")
    public void delete(@PathVariable String countryCode, @PathVariable String language) {
        CountryLanguageId id = new CountryLanguageId();
        id.setCountryCode(countryCode);
        id.setLanguage(language);
        repo.deleteById(id);
    }
}