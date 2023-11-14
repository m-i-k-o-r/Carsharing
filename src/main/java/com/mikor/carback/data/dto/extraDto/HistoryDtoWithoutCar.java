package com.mikor.carback.data.dto.extraDto;

import com.mikor.carback.data.dto.ViolationDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDtoWithoutCar {
    private Long id;
    private ClientDtoWithoutHistory client;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    Set<ViolationDto> violation;
}
