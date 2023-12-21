package com.mikor.carback.data.forms.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationCarForm {
    @NotNull
    @NotBlank
    private Long locationId;
}
