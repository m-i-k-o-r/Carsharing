package com.mikor.carback.controllers;

import com.mikor.carback.data.dto.ClientDto;
import com.mikor.carback.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping()
    @Operation(summary = "Get all clients", responses = {
            @ApiResponse(responseCode = "200", description = "Clients found", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ClientDto.class)))
            }),
            @ApiResponse(responseCode = "404", description = "No clients found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by id", responses = {
            @ApiResponse(responseCode = "200", description = "Client found", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ClientDto.class)))
            }),
            @ApiResponse(responseCode = "404", description = "No client found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public ClientDto getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PostMapping("/create")
    @Operation(summary = "Create client", responses = {
            @ApiResponse(responseCode = "201", description = "Client create", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "invalid fields to creating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "500", description = "An error occurred while creating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public ClientDto createClient(@RequestParam("name") String name,
                                  @RequestParam("passportData") Long passportData,
                                  @RequestParam("cartNumber") Long cartNumber,
                                  @RequestParam("phoneNumber") Long phoneNumber) {
        return clientService.createClient(name, passportData, cartNumber, phoneNumber);
    }

    @PutMapping("/{id}/updateClient")
    @Operation(summary = "Update client", responses = {
            @ApiResponse(responseCode = "200", description = "Client update", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "invalid fields to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No client found to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "500", description = "An error occurred while updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public ClientDto updateClientById(@PathVariable Long id,
                                   @RequestParam("name") String name,
                                   @RequestParam("passportData") Long passportData,
                                   @RequestParam("cartNumber") Long cartNumber,
                                   @RequestParam("phoneNumber") Long phoneNumber) {
        return clientService.updateClient(id, name, passportData, cartNumber, phoneNumber);
    }

    @PutMapping("/{id}/addHistory")
    @Operation(summary = "Add history client", responses = {
            @ApiResponse(responseCode = "200", description = "Client add history", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "invalid fields to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No client found to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "500", description = "An error occurred while updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public void addHistoryClientById(@PathVariable Long id,
                                     @RequestParam("historyId") Long historyId) {
        clientService.addHistoryClient(id, historyId);
    }

    @DeleteMapping("/{id}/delete")
    @Operation(summary = "Delete client", responses = {
            @ApiResponse(responseCode = "200", description = "Client delete"),
            @ApiResponse(responseCode = "404", description = "No client found to deleting", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public void deleteClientById(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
