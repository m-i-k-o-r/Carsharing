package com.mikor.carback.services;

import com.mikor.carback.data.dto.ClientDto;
import com.mikor.carback.data.forms.client.CreateClientForm;
import com.mikor.carback.data.forms.client.HistoryClientForm;
import com.mikor.carback.data.forms.client.UpdateClientFrom;
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

    public ClientDto createClient(CreateClientForm form) {
        return ClientMapper.INSTANCE.toDto(clientRepository.save(Client.builder()
                .name(form.getName())
                .passportData(form.getPassportData())
                .cardNumber(form.getCartNumber())
                .phoneNumber(form.getPhoneNumber())
                .password(form.getPassword())
                .build()));
    }

    public ClientDto updateClient(Long id, UpdateClientFrom form) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with this id not found"));
        client.setName(form.getName());
        client.setPassportData(form.getPassportData());
        client.setCardNumber(form.getCartNumber());
        client.setPhoneNumber(form.getPhoneNumber());
        client.setPassword(form.getPassword());
        client = clientRepository.save(client);
        return ClientMapper.INSTANCE.toDto(client);
    }

    public ClientDto addHistoryClient(Long id, HistoryClientForm form) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with this id not found"));
        Set<History> histories = client.getHistories();
        histories.add(historyRepository.findById(form.getHistoryId()).orElseThrow(() -> new NotFoundException("History with this id not found")));
        client.setHistories(histories);
        clientRepository.save(client);
        return ClientMapper.INSTANCE.toDto(client);
    }

    public ClientDto removeHistoryClient(Long id, HistoryClientForm form) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with this id not found"));
        History history = historyRepository.findById(form.getHistoryId()).orElseThrow(() -> new NotFoundException("History with this id not found"));
        client.getHistories().remove(history);
        historyRepository.delete(history);
        clientRepository.save(client);
        return ClientMapper.INSTANCE.toDto(client);
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
