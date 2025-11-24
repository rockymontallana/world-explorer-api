package com.example.world_explorer_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String countrycode; // FK to Country

    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private Integer population;

    // Relationship
    @ManyToOne
    @JoinColumn(name = "countrycode", referencedColumnName = "code", insertable = false, updatable = false)
    private Country country;
}