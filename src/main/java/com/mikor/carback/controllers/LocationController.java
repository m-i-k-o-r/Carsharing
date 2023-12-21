package com.mikor.carback.controllers;

import com.mikor.carback.data.dto.LocationDto;
import com.mikor.carback.services.LocationService;
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
@RequestMapping("/location")
@CrossOrigin("http://localhost:5173/")
public class LocationController {
    private final LocationService locationService;

    @GetMapping()
    @Operation(summary = "Get all locations", responses = {
            @ApiResponse(responseCode = "200", description = "Locations found", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = LocationDto.class)))
            }),
            @ApiResponse(responseCode = "404", description = "No locations found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public List<LocationDto> getAllLocations() {
        return locationService.getAllLocation();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get location by id", responses = {
            @ApiResponse(responseCode = "200", description = "Location found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LocationDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "No location found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public LocationDto getLocationById(@PathVariable Long id) {
        return locationService.getLocation(id);
    }

    @PostMapping("/create")
    @Operation(summary = "Create location", responses = {
            @ApiResponse(responseCode = "201", description = "Location create", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LocationDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "invalid fields to creating location", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public LocationDto createLocation(@RequestParam("city") String city,
                                   @RequestParam("width") double width,
                                   @RequestParam("height") double height) {
        return locationService.createLocation(city, width, height);
    }

    @PutMapping("/{id}/updateLocation")
    @Operation(summary = "Update location", responses = {
            @ApiResponse(responseCode = "200", description = "Location update", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LocationDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to updating location", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No location found to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public LocationDto updateLocationById(@PathVariable Long id,
                                       @RequestParam("city") String city,
                                       @RequestParam("width") double width,
                                       @RequestParam("height") double height) {
        return locationService.updateLocation(id, city, width, height);
    }

    @DeleteMapping("/{id}/delete")
    @Operation(summary = "Delete location", responses = {
            @ApiResponse(responseCode = "200", description = "Location delete"),
            @ApiResponse(responseCode = "404", description = "No location found to deleting", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public void deleteLocationById(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }

}
