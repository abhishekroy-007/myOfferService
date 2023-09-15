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
public class CohortAndOffer {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    @JsonProperty("id")
    @Column(name = "id")
    private String id;

    @JsonProperty("cohort_id")
    @Column(name = "cohort_id")
    private String cohortId;

    @JsonProperty("offer_meta_id")
    @Column(name = "offer_meta_id")
    private String offerMetaId;

    @JsonProperty("enable_offer_for_cohort")
    @Column(name = "enable_offer_for_cohort")
    private Boolean enableOfferForCohort;
}
