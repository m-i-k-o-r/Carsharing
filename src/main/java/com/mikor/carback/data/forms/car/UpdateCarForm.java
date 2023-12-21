package com.mikor.carback.data.forms.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCarForm {
    @NotNull
    @NotBlank
    private String number;
    @NotNull
    @NotBlank
    private String color;
    @NotNull
    @NotBlank
    private double rentalPrice;
}
