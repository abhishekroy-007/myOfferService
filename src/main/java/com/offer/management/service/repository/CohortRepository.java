package com.offer.management.service.repository;

import com.offer.management.service.entity.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CohortRepository extends JpaRepository<Cohort,String> {
    Optional<Cohort> findByCohortName(String cohortName);
}
