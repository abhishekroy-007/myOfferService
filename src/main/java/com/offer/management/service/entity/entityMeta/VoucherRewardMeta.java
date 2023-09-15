package com.offer.management.service.entity.entityMeta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.offer.management.service.model.VoucherRewardType;
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
public class VoucherRewardMeta {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    @JsonProperty("voucher_reward_meta_id")
    @Column(name = "voucher_reward_meta_id")
    private String voucherRewardMetaId;

    @JsonProperty("voucher_reward_type")
    @Column(name = "voucher_reward_type")
    private VoucherRewardType voucherRewardType;

    @JsonProperty("voucher_amount")
    @Column(name = "voucher_amount")
    private String voucherAmount;

    @JsonProperty("conditional_amount")
    @Column(name = "conditional_amount")
    private String conditionalAmount;
}
