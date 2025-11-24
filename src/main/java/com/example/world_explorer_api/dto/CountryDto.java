package com.example.world_explorer_api.dto;

import lombok.Data;

@Data
public class CountryDto {
    private String code;
    private String name;
    private String continent;
    private String region;
    private Integer population;
}