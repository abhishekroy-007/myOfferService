package com.offer.management.service.controller;

import com.offer.management.service.entity.Order;
import com.offer.management.service.model.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IOrderController {
    @PostMapping("/v1/completeOrderPostPayment")
    public ResponseEntity<Order> completeOrderPostPayment(@RequestBody OrderRequest orderRequest);
}
