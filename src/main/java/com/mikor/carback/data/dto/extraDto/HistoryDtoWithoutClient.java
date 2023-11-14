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
public class HistoryDtoWithoutClient {
    private Long id;
    private CarDtoWithoutHistory car;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    Set<ViolationDto> violation;
}
