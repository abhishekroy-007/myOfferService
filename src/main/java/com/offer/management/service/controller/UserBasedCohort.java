package com.offer.management.service.controller;


import com.offer.management.service.entity.Cohort;
import com.offer.management.service.entity.User;
import com.offer.management.service.services.CohortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserBasedCohort implements ICohortController {

    @Autowired
    CohortService cohortService;

    @Override
    public ResponseEntity createCohort(List<User> users, String cohortName) {
        Cohort cohort = cohortService.createCohort(users, cohortName);
        return ResponseEntity.status(HttpStatus.OK).body(cohort);
    }

    @Override
    public ResponseEntity<Cohort> getCohortByName(String cohortName) {
        Cohort cohort = cohortService.findCohortByName(cohortName);
        return ResponseEntity.status(HttpStatus.OK).body(cohort);
    }

    @Override
    public ResponseEntity<List<Cohort>> getAllCohort() {
        List<Cohort> cohort = cohortService.getAllCohorts();
        return ResponseEntity.status(HttpStatus.OK).body(cohort);
    }


}
