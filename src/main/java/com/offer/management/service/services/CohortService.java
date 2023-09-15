package com.offer.management.service.services;

import com.offer.management.service.entity.Cohort;
import com.offer.management.service.entity.User;
import com.offer.management.service.exception.UserNotFoundException;
import com.offer.management.service.repository.CohortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CohortService {

    @Autowired
    CohortRepository cohortRepository;

    public Cohort createCohort(List<User> users, String cohortName) {
        String userIds = "";
        for (User user : users) {
            userIds = userIds + "," + user.getId();
        }
        Cohort cohort = Cohort.builder()
                .cohortName(cohortName)
                .userIds(userIds)
                .build();
        cohortRepository.save(cohort);
        return cohort;
    }

    public Cohort findCohortByName(String cohortName) {
        Optional<Cohort> cohort = cohortRepository.findByCohortName(cohortName);
        if (!cohort.isPresent()) {
            throw new UserNotFoundException("Cohort Not Found Exception");
        }
        return cohort.get();
    }


    public List<Cohort> getAllCohorts() {
        return cohortRepository.findAll();
    }

    public Cohort findCohortByCohortId(String cohortId) {
        Optional<Cohort> cohort = cohortRepository.findById(cohortId);
        if (!cohort.isPresent()) {
            throw new UserNotFoundException("Cohort Not Found Exception");
        }
        return cohort.get();
    }
}
