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
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping()
    @Operation(summary = "get all histories", responses = {
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
    @Operation(summary = "get all histories with have end date", responses = {
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

    @GetMapping("/{id}")
    @Operation(summary = "get history by id", responses = {
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
            @ApiResponse(responseCode = "400", description = "invalid fields to starting", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "500", description = "An error occurred while starting", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public HistoryDto startHistory(@RequestParam("clientId") Long clientId,
                                   @RequestParam("carId") Long carId) {
        return historyService.startHistory(clientId, carId);
    }

    @PutMapping("/{id}/end")
    @Operation(summary = "completion history", responses = {
            @ApiResponse(responseCode = "200", description = "History completion", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = HistoryDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "invalid fields to completing", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No history found to completing", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "500", description = "An error occurred while completing", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public HistoryDto endHistory(@PathVariable Long id) {
        return historyService.endHistory(id);
    }

    @PutMapping("/{id}/addViolation")
    @Operation(summary = "completion history", responses = {
            @ApiResponse(responseCode = "200", description = "History completion", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = HistoryDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "invalid fields to completing", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No history found to completing", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "500", description = "An error occurred while completing", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public HistoryDto addViolation(@PathVariable Long id,
                                   @RequestParam("violationId") Long violationId) {
        return historyService.addViolation(id, violationId);
    }

    @PutMapping("/{id}/removeViolation")
    @Operation(summary = "completion history", responses = {
            @ApiResponse(responseCode = "200", description = "History completion", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = HistoryDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "invalid fields to completing", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No history found to completing", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "500", description = "An error occurred while completing", content = {
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
