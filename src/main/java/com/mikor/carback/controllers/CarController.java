package com.mikor.carback.controllers;

import com.mikor.carback.data.dto.CarDto;
import com.mikor.carback.data.forms.car.CreateCarForm;
import com.mikor.carback.data.forms.car.LocationCarForm;
import com.mikor.carback.data.forms.car.UpdateCarForm;
import com.mikor.carback.services.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
@CrossOrigin("http://localhost:5173/")
public class CarController {
    private final CarService carService;

    @GetMapping()
    public List<CarDto> getAllCars() {
        return carService.getAllCar();
    }

    @GetMapping("/end")
    public List<CarDto> getAllCarsWithEnd() {
        return carService.getAllCarsWithEnd();
    }

    @GetMapping("/{id}")
    public CarDto getCar(@PathVariable Long id) {
        return carService.getCar(id);
    }

    @PostMapping("/create")
    public CarDto createCar(@Valid @RequestBody CreateCarForm form) {
        return carService.createCar(form);
    }

    @PutMapping("/{id}/updateCar")
    public CarDto updateCarById(@PathVariable Long id,
                                @Valid @RequestBody UpdateCarForm form) {
        return carService.updateCar(id, form);
    }

    @PutMapping("/{id}/addLocation")
    public CarDto setLocationById(@PathVariable Long id,
                                  @Valid @RequestBody LocationCarForm form) {
        return carService.addLocationCar(id, form);
    }

    @PutMapping("/{id}/removeLocation")
    public CarDto removeLocationById(@PathVariable Long id) {
        return carService.removeLocationCar(id);
    }

    @PutMapping("/{id}/addHistory/{historyId}")
    public CarDto addHistoryCarById(@PathVariable Long id,
                                    @PathVariable Long historyId) {
        return carService.addHistoryCar(id, historyId);
    }

    @PutMapping("/{id}/removeHistory/{historyId}")
    public CarDto removeHistoryById(@PathVariable Long id,
                                    @PathVariable Long historyId) {
        return carService.removeHistoryCar(id, historyId);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteCarById(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}


