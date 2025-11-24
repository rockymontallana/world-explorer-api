package com.example.world_explorer_api.dto;

import lombok.Data;

@Data
public class CityDto {
    private Integer id;
    private String name;
    private String countryCode;
    private String district;
    private Integer population;
}