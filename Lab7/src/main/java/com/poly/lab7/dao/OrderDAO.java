package com.poly.lab7.dao;

import com.poly.lab7.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer> {
}
