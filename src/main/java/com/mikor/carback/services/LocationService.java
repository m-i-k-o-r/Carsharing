package com.mikor.carback.services;

import com.mikor.carback.data.dto.LocationDto;
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

    public LocationDto createLocation(String city, double width, double height) {
        return LocationMapper.INSTANCE.toDto(locationRepository.save(Location.builder()
                .city(city)
                .width(width)
                .height(height)
                .build()));
    }

    public LocationDto updateLocation(Long id, String city, double width, double height) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new NotFoundException("Location with this id not found"));
        location.setCity(city);
        location.setWidth(width);
        location.setHeight(height);
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
