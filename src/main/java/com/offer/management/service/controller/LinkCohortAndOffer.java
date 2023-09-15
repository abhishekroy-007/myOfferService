package com.offer.management.service.controller;

import com.offer.management.service.entity.CohortAndOffer;
import com.offer.management.service.model.CohortAndOfferRequest;
import com.offer.management.service.services.LinkCohortAndOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkCohortAndOffer implements ILinkCohortController{

    @Autowired
    LinkCohortAndOfferService linkCohortAndOfferService;

    @Override
    public ResponseEntity<CohortAndOffer> linkOfferWithCohort(CohortAndOfferRequest cohortAndOfferRequest) {
        CohortAndOffer cohortAndOffer = linkCohortAndOfferService.link(cohortAndOfferRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(cohortAndOffer);
    }
}
