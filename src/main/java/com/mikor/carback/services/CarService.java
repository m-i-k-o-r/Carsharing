package com.mikor.carback.services;

import com.mikor.carback.data.dto.CarDto;
import com.mikor.carback.data.forms.car.CreateCarForm;
import com.mikor.carback.data.forms.car.LocationCarForm;
import com.mikor.carback.data.forms.car.UpdateCarForm;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final LocationRepository locationRepository;
    private final HistoryRepository historyRepository;

    public CarDto createCar(CreateCarForm form) {
        return CarMapper.INSTANCE.toDto(carRepository.save(Car.builder()
                .name(form.getName())
                .year(form.getYear())
                .number(form.getNumber())
                .color(form.getColor())
                .rentalPrice(form.getRentalPrice())
                .build()));
    }

    public CarDto updateCar(Long id, UpdateCarForm form) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found"));
        car.setNumber(form.getNumber());
        car.setColor(form.getColor());
        car.setRentalPrice(form.getRentalPrice());
        car = carRepository.save(car);
        return CarMapper.INSTANCE.toDto(car);
    }

    public CarDto addLocationCar(Long id, LocationCarForm form) {
        Location location = locationRepository.findById(form.getLocationId()).orElseThrow(() -> new NotFoundException("Location with this id not found"));
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found"));
        car.setLocation(location);
        carRepository.save(car);
        return CarMapper.INSTANCE.toDto(car);
    }

    public CarDto removeLocationCar(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found"));
        car.setLocation(null);
        carRepository.save(car);
        return CarMapper.INSTANCE.toDto(car);
    }

    public CarDto addHistoryCar(Long id, Long historyId) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found"));
        Set<History> histories = car.getHistories();
        histories.add(historyRepository.findById(historyId).orElseThrow(() -> new NotFoundException("History with this id not found")));
        car.setHistories(histories);
        carRepository.save(car);
        return CarMapper.INSTANCE.toDto(car);
    }

    public CarDto removeHistoryCar(Long id, Long historyId) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found"));
        History history = historyRepository.findById(historyId).orElseThrow(() -> new NotFoundException("History with this id not found"));
        car.getHistories().remove(history);
        historyRepository.delete(history);
        carRepository.save(car);
        return CarMapper.INSTANCE.toDto(car);
    }

    public CarDto getCar(Long id) {
        return CarMapper.INSTANCE.toDto(carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found")));
    }

    public List<CarDto> getAllCar() {
        return CarMapper.INSTANCE.toDto(carRepository.findAll());
    }

    public List<CarDto> getAllCarsWithEnd() {
        List<Car> sortCars = new ArrayList<>();
        List<Car> cars = carRepository.findAll();
        for (Car c : cars) {
            boolean flag = true;
            for (History h : c.getHistories()) {
                if (h.getEndDate() == null) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sortCars.add(c);
            }
        }
        return CarMapper.INSTANCE.toDto(sortCars);
    }

    public void deleteCar(Long id) {
        carRepository.delete(carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found")));
    }
}
