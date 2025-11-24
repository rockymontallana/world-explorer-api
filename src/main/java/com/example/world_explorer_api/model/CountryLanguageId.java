package com.example.world_explorer_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class CountryLanguageId implements Serializable {
    @Column(name = "countrycode")
    private String countryCode;

    @Column(name = "language")
    private String language;
}