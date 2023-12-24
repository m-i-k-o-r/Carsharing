package com.mikor.carback.controllers;

import com.mikor.carback.data.dto.ClientDto;
import com.mikor.carback.data.forms.client.CreateClientForm;
import com.mikor.carback.data.forms.client.HistoryClientForm;
import com.mikor.carback.data.forms.client.UpdateClientFrom;
import com.mikor.carback.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
@CrossOrigin("http://localhost:5173/")
public class ClientController {
    private final ClientService clientService;

    @GetMapping()
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @GetMapping("/num/{number}")
    public ClientDto getClientByNumber(@PathVariable Long number) {
        return clientService.getClientByNumber(number);
    }

    @PostMapping("/create")
    public ClientDto createClient(@Valid @RequestBody CreateClientForm form) {
        return clientService.createClient(form);
    }

    @PutMapping("/{id}/updateClient")
    public ClientDto updateClientById(@PathVariable Long id,
                                      @Valid @RequestBody UpdateClientFrom form) {
        return clientService.updateClient(id, form);
    }

    @PutMapping("/{id}/addHistory")
    public ClientDto addHistoryClientById(@PathVariable Long id,
                                          @Valid @RequestBody HistoryClientForm form) {
        return clientService.addHistoryClient(id, form);
    }

    @PutMapping("/{id}/removeHistory")
    public ClientDto removeHistoryById(@PathVariable Long id,
                                       @Valid @RequestBody HistoryClientForm form) {
        return clientService.removeHistoryClient(id, form);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteClientById(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
