package com.petproject.shineexpert.service.impl;

import com.petproject.shineexpert.entity.Car;
import com.petproject.shineexpert.repository.CarRepository;
import com.petproject.shineexpert.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car findById(Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new EntityNotFoundException("Car with id = " + carId + " not found"));
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Long carId, Car car) {

        carRepository.findById(carId)
                .orElseThrow(() -> new EntityNotFoundException("Car with id = " + carId + " not found"));
        car.setId(carId);

        return carRepository.save(car);
    }

    @Override
    public void delete(Car car) {
        if (carRepository.findById(car.getId()).isPresent()) {
            carRepository.delete(car);
        }
    }

    @Override
    public void deleteById(Long carId) {
        if (carRepository.existsById(carId)) {
            carRepository.deleteById(carId);
        }
    }
}
