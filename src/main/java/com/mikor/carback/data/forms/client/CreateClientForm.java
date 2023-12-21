package com.mikor.carback.data.forms.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateClientForm {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private Long passportData;
    @NotNull
    @NotBlank
    private Long cartNumber;
    @NotNull
    @NotBlank
    private Long phoneNumber;
    @NotNull
    @NotBlank
    private String password;
}
