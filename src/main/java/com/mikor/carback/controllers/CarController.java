package com.mikor.carback.controllers;

import com.mikor.carback.data.dto.CarDto;
import com.mikor.carback.services.CarService;
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
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping()
    @Operation(summary = "Get all cars", responses = {
            @ApiResponse(responseCode = "200", description = "Cars found", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CarDto.class)))
            }),
            @ApiResponse(responseCode = "404", description = "No cars found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public List<CarDto> getAllCars() {
        return carService.getAllCar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get car by id", responses = {
            @ApiResponse(responseCode = "200", description = "Car found", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CarDto.class)))
            }),
            @ApiResponse(responseCode = "404", description = "No car found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public CarDto getCar(@PathVariable Long id) {
        return carService.getCar(id);
    }

    @PostMapping("/create")
    @Operation(summary = "Create car", responses = {
            @ApiResponse(responseCode = "201", description = "Car create", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields for creating car", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "409", description = "Conflict with an existing car resource", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public CarDto createCar(@RequestParam("name") String name,
                          @RequestParam("year") int year,
                          @RequestParam("number") String number,
                          @RequestParam("color") String color,
                          @RequestParam("rentalPrice") double rentalPrice) {
        return carService.createCar(name, year, number, color, rentalPrice);
    }

    @PutMapping("/{id}/updateCar")
    @Operation(summary = "Update car", responses = {
            @ApiResponse(responseCode = "200", description = "Car update", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to updating car", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No car found to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public CarDto updateCarById(@PathVariable Long id,
                             @RequestParam("number") String number,
                             @RequestParam("color") String color,
                             @RequestParam("rentalPrice") double rentalPrice) {
        return carService.updateCar(id, number, color, rentalPrice);
    }

    @PutMapping("/{id}/addLocation")
    @Operation(summary = "Add location car", responses = {
            @ApiResponse(responseCode = "200", description = "Car add location", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to updating car", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No car found to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public void setLocationById(@PathVariable Long id,
                                @RequestParam("locationId") Long locationId) {
        carService.addLocationCar(id, locationId);
    }

    @PutMapping("/{id}/removeLocation")
    @Operation(summary = "Remove location car", responses = {
            @ApiResponse(responseCode = "200", description = "Car remove location", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to updating car", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No car found to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public void removeLocationById(@PathVariable Long id) {
        carService.removeLocationCar(id);
    }

    @PutMapping("/{id}/addHistory")
    @Operation(summary = "Add history car", responses = {
            @ApiResponse(responseCode = "200", description = "Car add history", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to updating car", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No car found to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public void addHistoryCarById(@PathVariable Long id,
                                  @RequestParam("historyId") Long historyId) {
        carService.addHistoryCar(id, historyId);
    }

    @PutMapping("/{id}/removeHistory")
    @Operation(summary = "Remove history car", responses = {
            @ApiResponse(responseCode = "200", description = "Car remove history", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid fields to updating car", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "No car found to updating", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public void removeHistoryById(@PathVariable Long id,
                                   @RequestParam("historyId") Long historyId) {
        carService.removeHistoryCar(id, historyId);
    }

    @DeleteMapping("/{id}/delete")
    @Operation(summary = "Delete car", responses = {
            @ApiResponse(responseCode = "200", description = "Car delete"),
            @ApiResponse(responseCode = "404", description = "No car found to deleting", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class))
            })
    })
    public void deleteCarById(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
