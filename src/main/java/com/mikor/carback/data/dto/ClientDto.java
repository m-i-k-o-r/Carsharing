package com.mikor.carback.data.dto;

import com.mikor.carback.data.dto.extraDto.HistoryDtoWithoutClient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private Long id;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Invalid Name: Name is NULL")
    private String name;

    @Pattern(regexp = "^\\d{10}$",
            message = "Card Number must be in the format 11 22 3333")
    @NotBlank(message = "Passport Data is required")
    @NotNull(message = "Invalid Passport Data: Passport Data is NULL")
    private Long passportData;

    @Pattern(regexp = "^\\d{16}$",
            message = "Card Number must be in the format 1111 2222 3333 4444")
    @NotBlank(message = "Card Number is required")
    @NotNull(message = "Invalid Card Number: Card Number is NULL")
    private Long cardNumber;

    @Pattern(regexp = "^\\+7\\d{10}$",
            message = "Phone Number must be in the format +7 999 999 99 99")
    @NotBlank(message = "Phone Number number is required")
    @NotNull(message = "Invalid Phone Number: Phone Number is NULL")
    private Long phoneNumber;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Invalid Name: Name is NULL")
    private String password;

    Set<HistoryDtoWithoutClient> histories;
}
