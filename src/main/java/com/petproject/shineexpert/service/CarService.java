package com.petproject.shineexpert.service;

import com.petproject.shineexpert.entity.Car;

import java.util.List;

public interface CarService {

    Car findById(Long carId);

    List<Car> findAll();

    Car save(Car car);

    Car update(Long carId, Car car);

    void delete(Car car);

    void deleteById(Long carId);
}
