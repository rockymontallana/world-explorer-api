package com.example.world_explorer_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "country")  // Table name matches MySQL
public class Country {
    @Id
    @Column(length = 3)
    private String code; // ISO code, primary key

    @Column(nullable = false)
    private String name;

    @Column
    private String continent;
    @Column
    private String region;
    @Column(name = "surfacearea")
    private Float surfaceArea;
    @Column
    private Integer indepyear;
    @Column(nullable = false)
    private Integer population;
    @Column(name = "lifeexpectancy")
    private Float lifeExpectancy;
    @Column(name = "gnp")
    private Float gnp;
    @Column(name = "gnpold")
    private Float gnpOld;
    @Column(nullable = false)
    private String localname;
    @Column(nullable = false)
    private String governmentform;
    @Column
    private String headofstate;
    @Column
    private Integer capital;
    @Column(nullable = false, length = 2)
    private String code2;

    // Relationships
    @OneToMany(mappedBy="country")
    private List<City> cities;

    @OneToMany(mappedBy="country")
    private List<CountryLanguage> languages;
}