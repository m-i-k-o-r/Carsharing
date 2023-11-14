package com.mikor.carback.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "city", nullable = false,
            columnDefinition = "varchar(55)")
    private String city;

    @Column(name = "width", nullable = false,
            columnDefinition = "decimal(9, 6)")
    private double width;

    @Column(name = "height", nullable = false,
            columnDefinition = "decimal(9, 6)")
    private double height;
}
