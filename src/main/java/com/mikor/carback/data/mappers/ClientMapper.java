package com.mikor.carback.data.mappers;

import com.mikor.carback.data.dto.ClientDto;
import com.mikor.carback.models.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto toDto(Client client);

    List<ClientDto> toDto(List<Client> clients);
}