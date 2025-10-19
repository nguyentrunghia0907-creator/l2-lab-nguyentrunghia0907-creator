package com.poly.lab6.dao;

import com.poly.lab6.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {
    @Query("DELETE FROM OrderDetail od WHERE od.product = ?1")
    void deleteByProductId(Integer productId);
}
