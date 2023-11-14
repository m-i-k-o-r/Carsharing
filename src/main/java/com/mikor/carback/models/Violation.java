package com.mikor.carback.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "violation")
public class Violation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "type", nullable = false,
            columnDefinition = "varchar(55)")
    private String type;

    @Column(name = "description",
            columnDefinition = "text")
    private String description;

    @Column(name = "price", nullable = false,
            columnDefinition = "decimal(6, 2)")
    private double price;

    @ManyToOne
    @JoinColumn(name = "history_id")
    private History history;
}
