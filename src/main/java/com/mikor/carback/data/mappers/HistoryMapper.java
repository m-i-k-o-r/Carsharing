package com.mikor.carback.data.mappers;

import com.mikor.carback.data.dto.HistoryDto;
import com.mikor.carback.models.History;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HistoryMapper {

    HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class);

    HistoryDto toDto(History history);

    List<HistoryDto> toDto(List<History> histories);
}
