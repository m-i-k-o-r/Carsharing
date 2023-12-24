package com.mikor.carback.data.forms.violation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateViolationForm {
    @NotNull
    @NotBlank
    private String type;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @NotBlank
    private double price;
    @NotNull
    @NotBlank
    private Long historyId;
}
