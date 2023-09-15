package com.offer.management.service.repository;

import com.offer.management.service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByUserId(String userid);

    List<Order> findByUserIdAndBrandId(String userid, String brandId);
}
