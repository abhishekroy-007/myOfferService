package com.offer.management.service.repository;

import com.offer.management.service.entity.CohortAndOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkCohortAndOfferRepository extends JpaRepository<CohortAndOffer, String> {
    List<CohortAndOffer> findByOfferMetaId(String id);
}
