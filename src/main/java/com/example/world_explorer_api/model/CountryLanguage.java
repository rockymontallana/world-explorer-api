package com.example.world_explorer_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    @Column(nullable = false)
    private Boolean isofficial;
    @Column(nullable = false)
    private Float percentage;

    // Relationship
    @ManyToOne
    @JoinColumn(name = "countrycode", referencedColumnName = "code", insertable = false, updatable = false)
    private Country country;
}