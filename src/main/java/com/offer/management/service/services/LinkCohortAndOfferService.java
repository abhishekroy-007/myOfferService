package com.offer.management.service.services;

import com.offer.management.service.entity.Cohort;
import com.offer.management.service.entity.CohortAndOffer;
import com.offer.management.service.model.CohortAndOfferRequest;
import com.offer.management.service.repository.LinkCohortAndOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkCohortAndOfferService {

    @Autowired
    LinkCohortAndOfferRepository linkCohortAndOfferRepository;

    public CohortAndOffer link(CohortAndOfferRequest cohortAndOfferRequest) {
        CohortAndOffer cohortAndOffer = CohortAndOffer.builder()
                .cohortId(cohortAndOfferRequest.getCohortId())
                .offerMetaId(cohortAndOfferRequest.getOfferMetaId())
                .enableOfferForCohort(cohortAndOfferRequest.getEnableOfferForCohort())
                .build();
        linkCohortAndOfferRepository.save(cohortAndOffer);
        return cohortAndOffer;
    }

    public List<CohortAndOffer> getAllOffersByOfferMetaId(String id) {
        return linkCohortAndOfferRepository.findByOfferMetaId(id);
    }
}
