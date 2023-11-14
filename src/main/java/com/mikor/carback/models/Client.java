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
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false,
            columnDefinition = "varchar(55)")
    private String name;

    @Column(name = "passport_data", nullable = false, unique = true,
            columnDefinition = "bigint")
    private Long passportData;

    @Column(name = "card_number", nullable = false, unique = true,
            columnDefinition = "bigint")
    private Long cardNumber;

    @Column(name = "phone_number", nullable = false, unique = true,
            columnDefinition = "bigint")
    private Long phoneNumber;

    @OneToMany(mappedBy = "client")
    Set<History> histories;
}
