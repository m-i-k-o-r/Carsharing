package com.mikor.carback.data.dto.extraDto;

import com.mikor.carback.data.dto.LocationDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDtoWithoutHistory {
    private Long id;
    private String name;
    private int year;
    private String number;
    private String color;
    private double rentalPrice;
    private LocationDto location;
}
