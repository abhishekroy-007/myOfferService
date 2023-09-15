package com.offer.management.service.entity.entityMeta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.offer.management.service.model.RewardPointType;
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
public class RewardPointMeta {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    @JsonProperty("reward_point_meta_id")
    @Column(name = "reward_point_meta_id")
    private String rewardPointMetaId;

    @JsonProperty("reward_point_type")
    @Column(name = "reward_point_type")
    private RewardPointType rewardPointType;

    @JsonProperty("reward_Point_Awarded")
    @Column(name = "reward_Point_Awarded")
    private String rewardPointAwarded;

    @JsonProperty("money_To_Be_Spent")
    @Column(name = "money_To_Be_Spent")
    private String moneyToBeSpent;

    @JsonProperty("brand_types_to_not_allow")
    @Column(name = "brand_types_to_not_allow")
    private String brandTypesToNotAllow;
}
