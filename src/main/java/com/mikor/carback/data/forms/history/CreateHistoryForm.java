package com.mikor.carback.data.forms.history;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateHistoryForm {
    @NotNull
    @NotBlank
    private Long clientId;
    @NotNull
    @NotBlank
    private Long carId;
}
