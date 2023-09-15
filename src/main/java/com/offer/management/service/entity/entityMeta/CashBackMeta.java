package com.offer.management.service.entity.entityMeta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.offer.management.service.model.CashBackType;
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
public class CashBackMeta {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    @JsonProperty("cash_back_meta_id")
    @Column(name = "cash_back_meta_id")
    private String cashBackMetaId;

    @JsonProperty("cash_back_type")
    @Column(name = "cash_back_type")
    private CashBackType cashBackType;

    @JsonProperty("discount_Value_On_Condition")
    @Column(name = "discount_Value_On_Condition")
    private String discountValueOnCondition;

    @JsonProperty("brand_name")
    @Column(name = "brand_name")
    private String brandName;

}
