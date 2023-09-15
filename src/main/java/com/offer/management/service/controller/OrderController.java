package com.offer.management.service.controller;

import com.offer.management.service.entity.Order;
import com.offer.management.service.model.OrderRequest;
import com.offer.management.service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements IOrderController {

    @Autowired
    OrderService orderService;
    @Override
    public ResponseEntity<Order> completeOrderPostPayment(OrderRequest orderRequest) {
        Order order = orderService.markOrderCompletedPostPaymentWithOfferApplied(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

}
