package com.petproject.shineexpert.service;

import com.petproject.shineexpert.dto.OrderDto;
import com.petproject.shineexpert.entity.Order;

import java.util.List;

public interface OrderService {

    Order findById(Long orderId);

    List<Order> findAll();

    Order save(OrderDto order, Long carId);

    void deleteById(Long orderId);
}
