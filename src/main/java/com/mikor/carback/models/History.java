package com.mikor.carback.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "start_date", nullable = false,
            columnDefinition = "timestamp")
    private LocalDateTime startDate;

    @Column(name = "end_date",
            columnDefinition = "timestamp")
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "history")
    Set<Violation> violation;
}
