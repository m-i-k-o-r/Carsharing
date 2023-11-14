package com.mikor.carback.data.mappers;

import com.mikor.carback.data.dto.LocationDto;
import com.mikor.carback.models.Location;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LocationMapper {

    LocationMapper INSTANCE  = Mappers.getMapper(LocationMapper.class);

    LocationDto toDto(Location location);

    List<LocationDto> toDto(List<Location> locations);
}
