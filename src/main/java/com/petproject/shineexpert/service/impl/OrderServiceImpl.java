package com.petproject.shineexpert.service.impl;

import com.petproject.shineexpert.dto.OrderDto;
import com.petproject.shineexpert.entity.*;
import com.petproject.shineexpert.repository.OrderRepository;
import com.petproject.shineexpert.service.CarService;
import com.petproject.shineexpert.service.EmployeeService;
import com.petproject.shineexpert.service.OrderService;
import com.petproject.shineexpert.service.ServicesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CarService carService;
    private final ServicesService servicesService;

    private final EmployeeService employeeService;

    @Override
    public Order findById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException(" Unable to get order"));
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order save(OrderDto orderDto, Long carId) {
        Order order = new Order();
        List<Services> services = new ArrayList<>();
        for (Long id :
                orderDto.getServiceIds()) {
            services.add(servicesService.findById(id));
        }

        Car car = carService.findById(carId);
        order.setCar(car);
        order.setDateTime(LocalDateTime.now());
        order.setComment(orderDto.getComment());
        order.getServices().addAll(services);
        order.setPrice(countTotalPrice(services, car));

        car.getOwner().incrementVisitCounter();
//        Employee employee = employeeService.findAllActive().stream().findFirst().get();
//        employee.setActive(false);
//        order.setEmployee(employee);

        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    private String countTotalPrice(List<Services> services, Car car) {
        double sum = services.stream()
                .map(Services::getPrice)
                .mapToDouble(Double::parseDouble)
                .sum();

        switch (car.getCarType()) {
            case MIDDLE -> sum += 20;
            case CROSSOVER -> sum += 30;
            case SUV -> sum += 40;
            default -> sum += 0;
        }
        double discount = calculateDiscount(car.getOwner());
        sum*=discount;
        return String.valueOf(sum);
    }

    private double calculateDiscount(Owner owner) {
        if (owner.getVisitCounter() == 5){
            owner.setVisitCounter(0);
            return 0.5;
        }
        return 1;
    }
}
