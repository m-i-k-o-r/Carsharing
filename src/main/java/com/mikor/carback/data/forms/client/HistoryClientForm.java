package com.mikor.carback.data.forms.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoryClientForm {
    @NotNull
    @NotBlank
    private Long historyId;
}
