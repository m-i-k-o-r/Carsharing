package com.mikor.carback.controllers;

import com.mikor.carback.data.dto.ViolationDto;
import com.mikor.carback.services.ViolationService;
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
@RequestMapping("/violation")
@RequiredArgsConstructor
public class ViolationController {
    private final ViolationService violationService;

    @GetMapping()
    @Operation(summary = "Get all violations", responses = {
            @ApiResponse(responseCode = "200", description = "Violations found", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ViolationDto.class)))
            }),
            @ApiResponse(responseCode = "404", description = "No violations found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public List<ViolationDto> getAllViolations() {
        return violationService.getAllViolations();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get violation by id", responses = {
            @ApiResponse(responseCode = "200", description = "Violation found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ViolationDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "No violation found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public ViolationDto getViolationById(@PathVariable Long id) {
        return violationService.getViolation(id);
    }

    @PostMapping("/create")
    @Operation(summary = "Create violation", responses = {
            @ApiResponse(responseCode = "201", description = "Violation create", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ViolationDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to creating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public ViolationDto createViolation(@RequestParam("type") String type,
                                     @RequestParam("description") String description,
                                     @RequestParam("price") double price,
                                     @RequestParam("historyId") Long historyId) {
        return violationService.violationCreate(type, description, price, historyId);
    }

    @PutMapping("/{id}/updateViolation")
    @Operation(summary = "update violation", responses = {
            @ApiResponse(responseCode = "200", description = "Violation update", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ViolationDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No violation found to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public ViolationDto updateViolationById(@PathVariable Long id,
                                         @RequestParam("type") String type,
                                         @RequestParam("description") String description,
                                         @RequestParam("price") double price) {
        return violationService.updateViolation(id, type, description, price);
    }

    @DeleteMapping("/{id}/delete")
    @Operation(summary = "Delete violation", responses = {
            @ApiResponse(responseCode = "200", description = "Violation delete"),
            @ApiResponse(responseCode = "404", description = "No violation found to deleting", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public void deleteViolationById(@PathVariable Long id) {
        violationService.deleteViolation(id);
    }

}
