package com.offer.management.service.controller;

import com.offer.management.service.entity.Cohort;
import com.offer.management.service.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ICohortController {

    @PostMapping("/v1/createCohort")
    public ResponseEntity createCohort(@RequestBody List<User> users, @RequestParam String cohortName);

    @GetMapping("/v1/getCohortByName")
    public ResponseEntity<Cohort> getCohortByName(@RequestParam String cohortName);

    @GetMapping("/v1/getAllCohort")
    public ResponseEntity<List<Cohort>> getAllCohort();
}
