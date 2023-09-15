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
public class RewardValue {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    @JsonProperty("id")
    @Column(name = "id")
    private String id;


    @JsonProperty("user_Id")
    @Column(name = "user_Id")
    private String userId;

    @JsonProperty("reward_value")
    @Column(name = "reward_value")
    private Integer rewardValue;
}
