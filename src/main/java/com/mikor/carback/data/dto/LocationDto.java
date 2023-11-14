package com.mikor.carback.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private Long id;

    @NotBlank(message = "City Name is required")
    @NotNull(message = "Invalid City Name: City Name is NULL")
    private String city;

    @NotBlank(message = "Width Location is required")
    @NotNull(message = "Invalid Width Location: Width Location is NULL")
    private double width;

    @NotBlank(message = "Height is required")
    @NotNull(message = "Invalid Height Location: Height Location is NULL")
    private double height;
}
