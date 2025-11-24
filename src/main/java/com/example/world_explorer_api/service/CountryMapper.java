package com.example.world_explorer_api.service;

import com.example.world_explorer_api.model.Country;
import com.example.world_explorer_api.dto.CountryDto;

public class CountryMapper {
    public static CountryDto toDto(Country entity) {
        CountryDto dto = new CountryDto();
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setContinent(entity.getContinent());
        dto.setRegion(entity.getRegion());
        dto.setPopulation(entity.getPopulation());
        return dto;
    }

    public static Country toEntity(CountryDto dto) {
        Country entity = new Country();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setContinent(dto.getContinent());
        entity.setRegion(dto.getRegion());
        entity.setPopulation(dto.getPopulation());
        return entity;
    }
}