package com.mikor.carback.controllers;

import com.mikor.carback.data.dto.LocationDto;
import com.mikor.carback.data.forms.location.LocationForm;
import com.mikor.carback.services.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
@CrossOrigin("http://localhost:5173/")
public class LocationController {
    private final LocationService locationService;

    @GetMapping()
    public List<LocationDto> getAllLocations() {
        return locationService.getAllLocation();
    }

    @GetMapping("/{id}")
    public LocationDto getLocationById(@PathVariable Long id) {
        return locationService.getLocation(id);
    }

    @PostMapping("/create")
    public LocationDto createLocation(@Valid @RequestBody LocationForm form) {
        return locationService.createLocation(form);
    }

    @PutMapping("/{id}/updateLocation")
    public LocationDto updateLocationById(@PathVariable Long id,
                                          @Valid @RequestBody LocationForm form) {
        return locationService.updateLocation(id, form);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteLocationById(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }

}
