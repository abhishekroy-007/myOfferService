package com.offer.management.service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.offer.management.service.model.OfferType;
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
public class Offer {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    @JsonProperty("id")
    @Column(name = "id")
    private String id;

    @JsonProperty("brand_id")
    @Column(name = "brand_id")
    private String brandId; // One Brand can Have Multiple Offer Attached To Them

    @JsonProperty("offer_type")
    @Column(name = "offer_type")
    private OfferType offerType; // CashBack , RewardPoints , VoucherRewards

    @JsonProperty("offer_meta_id")
    @Column(name = "offer_meta_id")
    private String offerMetaId;
}
