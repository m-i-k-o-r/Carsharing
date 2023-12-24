package com.mikor.carback.data.forms.location;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationForm {
    @NotNull
    @NotBlank
    private String city;
    @NotNull
    @NotBlank
    private double width;
    @NotNull
    @NotBlank
    private double height;
}

