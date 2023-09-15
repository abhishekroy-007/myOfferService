package com.offer.management.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OfferRequest {
    @JsonProperty("brand_id")
    private String brandId;

    @JsonProperty("offer_type")
    private OfferType offerType; // CashBack , RewardPoints , VoucherRewards

    // TODO : offer_meta_id not required - removes post testing
    @JsonProperty("offer_meta_id")
    private String offerMetaId;


    // Voucher Properties

    @JsonProperty("voucher_reward_type")
    private VoucherRewardType voucherRewardType;

    @JsonProperty("voucher_amount")
    private String voucherAmount;

    @JsonProperty("conditional_amount")
    private String conditionalAmount;


    // Reward Point Meta Properties

    @JsonProperty("reward_point_type")
    private RewardPointType rewardPointType;

    @JsonProperty("reward_Point_Awarded")
    private String rewardPointAwarded;

    @JsonProperty("money_To_Be_Spent")
    private String moneyToBeSpent;

    @JsonProperty("brand_types_to_not_allow")
    private String brandTypesToNotAllow;


    // CashBack

    @JsonProperty("brand_name")
    private String brandName;

    //TODO : Get All fields in a stringified json for cahsback


}
