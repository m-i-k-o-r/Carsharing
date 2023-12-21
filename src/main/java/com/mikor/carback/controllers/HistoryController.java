package com.mikor.carback.controllers;


import com.mikor.carback.data.dto.HistoryDto;
import com.mikor.carback.services.HistoryService;
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
@RequiredArgsConstructor
@RequestMapping("/history")
@CrossOrigin("http://localhost:5173/")
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping()
    @Operation(summary = "Get all histories", responses = {
            @ApiResponse(responseCode = "200", description = "Histories found", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = HistoryDto.class)))
            }),
            @ApiResponse(responseCode = "404", description = "No histories found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public List<HistoryDto> getAllHistories() {
        return historyService.getAllHistories();
    }

    @GetMapping("/withEnd")
    @Operation(summary = "Get all histories with have end date", responses = {
            @ApiResponse(responseCode = "200", description = "Histories found", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = HistoryDto.class)))
            }),
            @ApiResponse(responseCode = "404", description = "No histories found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public List<HistoryDto> getAllHistoriesWithEnd() {
        return historyService.getAllEndDateHistory();
    }

    @GetMapping("/byClient/{clientId}")
    @Operation(summary = "Get all histories with one client", responses = {
            @ApiResponse(responseCode = "200", description = "Histories found", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = HistoryDto.class)))
            }),
            @ApiResponse(responseCode = "404", description = "No histories found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public List<HistoryDto> getHistoriesByClientId(@PathVariable Long clientId) {
        return historyService.getHistoriesByClientId(clientId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get history by id", responses = {
            @ApiResponse(responseCode = "200", description = "History found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = HistoryDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "No history found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public HistoryDto getHistoryById(@PathVariable Long id) {
        return historyService.getHistory(id);
    }

    @PostMapping("/start")
    @Operation(summary = "Start history", responses = {
            @ApiResponse(responseCode = "201", description = "History start", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = HistoryDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to starting history", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "409", description = "Conflict with an existing history resource", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public HistoryDto startHistory(@RequestParam("clientId") Long clientId,
                                   @RequestParam("carId") Long carId) {
        return historyService.startHistory(clientId, carId);
    }

    @PutMapping("/{id}/end")
    @Operation(summary = "Completion history", responses = {
            @ApiResponse(responseCode = "200", description = "History completion", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = HistoryDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to completing history", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No history found to completing", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public HistoryDto endHistory(@PathVariable Long id) {
        return historyService.endHistory(id);
    }

    @PutMapping("/{id}/addViolation")
    @Operation(summary = "Add violation history", responses = {
            @ApiResponse(responseCode = "200", description = "History add violation", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = HistoryDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to updating history", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No history found to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public HistoryDto addViolation(@PathVariable Long id,
                                   @RequestParam("violationId") Long violationId) {
        return historyService.addViolation(id, violationId);
    }

    @PutMapping("/{id}/removeViolation")
    @Operation(summary = "Remove violation history", responses = {
            @ApiResponse(responseCode = "200", description = "History remove violation", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = HistoryDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No history found to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public HistoryDto removeViolation(@PathVariable Long id,
                                      @RequestParam("violationId") Long violationId) {
        return historyService.removeViolation(id, violationId);
    }

    @DeleteMapping("/{id}/delete")
    @Operation(summary = "Delete history", responses = {
            @ApiResponse(responseCode = "200", description = "History delete"),
            @ApiResponse(responseCode = "404", description = "No history found to deleting", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public void deleteHistory(@PathVariable Long id) {
        historyService.deleteHistory(id);
    }

}
