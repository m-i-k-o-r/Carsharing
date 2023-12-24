package com.mikor.carback.services;

import com.mikor.carback.data.dto.LocationDto;
import com.mikor.carback.data.forms.location.LocationForm;
import com.mikor.carback.data.mappers.LocationMapper;
import com.mikor.carback.exceptions.NotFoundException;
import com.mikor.carback.models.Location;
import com.mikor.carback.repos.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationDto createLocation(LocationForm form) {
        return LocationMapper.INSTANCE.toDto(locationRepository.save(Location.builder()
                .city(form.getCity())
                .width(form.getWidth())
                .height(form.getHeight())
                .build()));
    }

    public LocationDto updateLocation(Long id, LocationForm form) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new NotFoundException("Location with this id not found"));
        location.setCity(form.getCity());
        location.setWidth(form.getWidth());
        location.setHeight(form.getHeight());
        location = locationRepository.save(location);
        return LocationMapper.INSTANCE.toDto(location);
    }

    public LocationDto getLocation(Long id) {
        return LocationMapper.INSTANCE.toDto(locationRepository.findById(id).orElseThrow(() -> new NotFoundException("Location with this id not found")));
    }

    public List<LocationDto> getAllLocation() {
        return LocationMapper.INSTANCE.toDto(locationRepository.findAll());
    }

    public void deleteLocation(Long id) {
        locationRepository.delete(locationRepository.findById(id).orElseThrow(() -> new NotFoundException("Location with this id not found")));
    }
}
