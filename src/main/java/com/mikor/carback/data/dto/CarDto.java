package com.mikor.carback.data.dto;

import com.mikor.carback.data.dto.extraDto.HistoryDtoWithoutCar;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private Long id;

    @NotBlank(message = "Name Car is required")
    @NotNull(message = "Invalid Name Car: Name Car is NULL")
    private String name;

    @NotBlank(message = "Year is required")
    @NotNull(message = "Invalid Year: Year is NULL")
    private int year;

    @NotBlank(message = "Number Car is required")
    @NotNull(message = "Invalid Number Car: Number Car is NULL")
    private String number;

    @NotBlank(message = "Color is required")
    @NotNull(message = "Invalid Color: Color is NULL")
    private String color;

    @NotBlank(message = "Rental Price is required")
    @NotNull(message = "Invalid Rental Price: Rental Price is NULL")
    private double rentalPrice;

    private LocationDto location;

    Set<HistoryDtoWithoutCar> histories;
}
