package com.mikor.carback.data.mappers;

import com.mikor.carback.data.dto.ViolationDto;
import com.mikor.carback.models.Violation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ViolationMapper {

    ViolationMapper INSTANCE  = Mappers.getMapper(ViolationMapper.class);

    ViolationDto toDto(Violation violation);

    List<ViolationDto> toDto(List<Violation> violations);
}
