package com.offer.management.service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    @JsonProperty("id")
    @Column(name = "id")
    private String id;


    @JsonProperty("user_id")
    @Column(name = "user_id")
    private String userId;

    @JsonProperty("payment_id")
    @Column(name = "payment_id")
    private String paymentId; // Assuming Payment Was Completed Once Order Has To Created

    // TODO : Remove dependency of over brandId
    //  : Required because of only swiggy offers to find orders in last 30 days
    @JsonProperty("brand_id")
    @Column(name = "brand_id")
    private String brandId;

    @JsonProperty("order_status")
    @Column(name = "order_status")
    private String orderStatus;

    @JsonProperty("offer_id")
    @Column(name = "offer_id")
    private String offerId;

    @JsonProperty("order_amount")
    @Column(name = "order_amount")
    private String orderAmount;

    @JsonProperty("created_on")
    @Column(name = "created_on")
    private String createdOn;

    @JsonProperty("updated_on")
    @Column(name = "updated_on")
    private String updatedOn;
}
