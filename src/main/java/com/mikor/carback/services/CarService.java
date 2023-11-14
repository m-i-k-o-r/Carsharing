package com.mikor.carback.services;

import com.mikor.carback.data.dto.CarDto;
import com.mikor.carback.data.mappers.CarMapper;
import com.mikor.carback.exceptions.NotFoundException;
import com.mikor.carback.models.Car;
import com.mikor.carback.models.History;
import com.mikor.carback.models.Location;
import com.mikor.carback.repos.CarRepository;
import com.mikor.carback.repos.HistoryRepository;
import com.mikor.carback.repos.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final LocationRepository locationRepository;
    private final HistoryRepository historyRepository;

    public CarDto createCar(String name, int year, String number, String color, double rentalPrice) {
        return CarMapper.INSTANCE.toDto(carRepository.save(Car.builder()
                .name(name)
                .year(year)
                .number(number)
                .color(color)
                .rentalPrice(rentalPrice)
                .build()));
    }

    public CarDto updateCar(Long id, String number, String color, double rentalPrice) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found"));
        car.setNumber(number);
        car.setColor(color);
        car.setRentalPrice(rentalPrice);
        car = carRepository.save(car);
        return CarMapper.INSTANCE.toDto(car);
    }

    public void addLocationCar(Long id, Long locationId) {
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new NotFoundException("Location with this id not found"));
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found"));
        car.setLocation(location);
        carRepository.save(car);
    }

    public void removeLocationCar(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found"));
        car.setLocation(null);
        carRepository.save(car);
    }

    public void addHistoryCar(Long id, Long historyId) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found"));
        Set<History> histories = car.getHistories();
        histories.add(historyRepository.findById(historyId).orElseThrow(() -> new NotFoundException("History with this id not found")));
        car.setHistories(histories);
        carRepository.save(car);
    }

    public void removeHistoryCar(Long id, Long historyId) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found"));
        History history = historyRepository.findById(historyId).orElseThrow(() -> new NotFoundException("History with this id not found"));
        car.getHistories().remove(history);
        historyRepository.delete(history);
        carRepository.save(car);
    }

    public CarDto getCar(Long id) {
        return CarMapper.INSTANCE.toDto(carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found")));
    }

    public List<CarDto> getAllCar() {
        return CarMapper.INSTANCE.toDto(carRepository.findAll());
    }

    public void deleteCar(Long id) {
        carRepository.delete(carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found")));
    }
}
