package com.mikor.carback.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViolationDto {
    private Long id;

    @NotBlank(message = "Type Violation is required")
    @NotNull(message = "Invalid Type Violation: Type Violation is NULL")
    private String type;

    @NotBlank(message = "Description is required")
    @NotNull(message = "Invalid Description Violation: Description Violation is NULL")
    private String description;

    @NotBlank(message = "Price Violation is required")
    @NotNull(message = "Invalid Price Violation: Price Violation is NULL")
    private double price;
}
