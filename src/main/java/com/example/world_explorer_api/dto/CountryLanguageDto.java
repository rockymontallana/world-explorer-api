package com.example.world_explorer_api.dto;

import lombok.Data;

@Data
public class CountryLanguageDto {
    private String countryCode;
    private String language;
    private Boolean isOfficial;
    private Float percentage;
}