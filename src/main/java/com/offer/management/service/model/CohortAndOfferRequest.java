package com.offer.management.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CohortAndOfferRequest {
    @JsonProperty("cohort_id")
    private String cohortId;

    @JsonProperty("offer_meta_id")
    private String offerMetaId;

    @JsonProperty("enable_offer_for_cohort")
    private Boolean enableOfferForCohort;
    // If Not Disabled Explicitly we assume offer is enabled for every user on platform for now
    // Can be implemented vice versa
}
