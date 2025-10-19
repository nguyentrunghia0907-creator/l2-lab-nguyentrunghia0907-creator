package com.poly.lab7.dao;

import com.poly.lab7.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {
}
