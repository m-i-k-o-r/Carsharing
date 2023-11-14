package com.mikor.carback.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false,
            columnDefinition = "varchar(55)")
    private String name;

    @Column(name = "year_of_production", nullable = false,
            columnDefinition = "integer")
    private int year;

    @Column(name = "number_plate", nullable = false,
            columnDefinition = "varchar(9)")
    private String number;

    @Column(name = "color", nullable = false,
            columnDefinition = "varchar(16)")
    private String color;

    @Column(name = "rental_price", nullable = false,
            columnDefinition = "decimal(8, 2)")
    private double rentalPrice;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "car")
    Set<History> histories;
}
