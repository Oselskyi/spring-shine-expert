package com.petproject.shineexpert.repository;

import com.petproject.shineexpert.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
