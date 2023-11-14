package com.mikor.carback.data.dto;

import com.mikor.carback.data.dto.extraDto.CarDtoWithoutHistory;
import com.mikor.carback.data.dto.extraDto.ClientDtoWithoutHistory;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDto {
    private Long id;
    private ClientDtoWithoutHistory client;
    private CarDtoWithoutHistory car;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    Set<ViolationDto> violation;
}
