package com.mikor.carback.data.mappers;

import com.mikor.carback.data.dto.CarDto;
import com.mikor.carback.models.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDto toDto(Car car);

    List<CarDto> toDto(List<Car> cars);
}
