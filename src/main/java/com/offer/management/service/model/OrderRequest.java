package com.offer.management.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class OrderRequest {
    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("payment_id")
    private String paymentId; // Assuming Payment Was Completed Once Order Has To Created

    @JsonProperty("brand_id")
    private String brandId;

    @JsonProperty("order_status")
    private String orderStatus;

    @JsonProperty("order_amount")
    private String orderAmount;
}
