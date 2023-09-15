package com.offer.management.service.controller;

import com.offer.management.service.entity.CohortAndOffer;
import com.offer.management.service.model.CohortAndOfferRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface ILinkCohortController {

    @PostMapping("/v1/linkOffersWithCohort")
    public ResponseEntity<CohortAndOffer> linkOfferWithCohort(@RequestBody CohortAndOfferRequest cohortAndOfferRequest);

}
