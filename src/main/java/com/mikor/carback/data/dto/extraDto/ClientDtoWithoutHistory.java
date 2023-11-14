package com.mikor.carback.data.dto.extraDto;

import com.mikor.carback.data.dto.HistoryDto;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDtoWithoutHistory {
    private Long id;
    private String name;
    private Long passportData;
    private Long cardNumber;
    private Long phoneNumber;
}
