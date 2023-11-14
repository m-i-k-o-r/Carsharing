package com.mikor.carback.services;

import com.mikor.carback.data.dto.ClientDto;
import com.mikor.carback.data.mappers.ClientMapper;
import com.mikor.carback.exceptions.NotFoundException;
import com.mikor.carback.models.Client;
import com.mikor.carback.models.History;
import com.mikor.carback.repos.ClientRepository;
import com.mikor.carback.repos.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final HistoryRepository historyRepository;

    public ClientDto createClient(String name, Long passportData, Long cartNumber, Long phoneNumber) {
        return ClientMapper.INSTANCE.toDto(clientRepository.save(Client.builder()
                .name(name)
                .passportData(passportData)
                .cardNumber(cartNumber)
                .phoneNumber(phoneNumber)
                .build()));
    }

    public ClientDto updateClient(Long id, String name, Long passportData, Long cartNumber, Long phoneNumber) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with this id not found"));
        client.setName(name);
        client.setPassportData(passportData);
        client.setCardNumber(cartNumber);
        client.setPhoneNumber(phoneNumber);
        client = clientRepository.save(client);
        return ClientMapper.INSTANCE.toDto(client);
    }

    public void addHistoryClient(Long id, Long historyId) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with this id not found"));
        Set<History> histories = client.getHistories();
        histories.add(historyRepository.findById(historyId).orElseThrow(() -> new NotFoundException("History with this id not found")));
        client.setHistories(histories);
        clientRepository.save(client);
    }

    public ClientDto getClient(Long id) {
        return ClientMapper.INSTANCE.toDto(clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with this id not found")));
    }

    public List<ClientDto> getAllClients() {
        return ClientMapper.INSTANCE.toDto(clientRepository.findAll());
    }

    public void deleteClient(Long id) {
        clientRepository.delete(clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with this id not found")));
    }

}
