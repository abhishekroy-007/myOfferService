package com.offer.management.service.services;

import com.offer.management.service.entity.CohortAndOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OfferValidatorService {
    @Autowired
    LinkCohortAndOfferService linkCohortAndOfferService;

    @Autowired
    CohortService cohortService;


    public boolean isUserAllowedForThisOffer(String userId, String offerMetaId) {
        List<CohortAndOffer> allCohorts = linkCohortAndOfferService.getAllOffersByOfferMetaId(offerMetaId);

        // If that offerMeta Id has been disabled and that user lies into that cohort return false
        for (CohortAndOffer iterator : allCohorts) {
            if(iterator.getEnableOfferForCohort().equals(Boolean.FALSE)) {
                List<String> userIdsLinkedToThisCohort = Arrays.asList(cohortService.findCohortByCohortId(iterator.getCohortId())
                        .getUserIds().split(","));
                for (String id : userIdsLinkedToThisCohort) {
                    if(userId.equals(id)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
