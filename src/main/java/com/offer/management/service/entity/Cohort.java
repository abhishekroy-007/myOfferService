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
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cohort {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    @JsonProperty("id")
    @Column(name = "id")
    private String id;

    @JsonProperty("cohort_name")
    @Column(name = "cohort_name")
    private String cohortName;

    @JsonProperty("user_ids")
    @Column(name = "user_ids")
    private String userIds;

}
