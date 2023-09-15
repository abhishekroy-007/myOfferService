package com.offer.management.service.services;

import org.springframework.stereotype.Service;

@Service
public class ProbabilityService {
    public Integer findProbabilityService(String userId) {
        int hash = userId.hashCode() & 0x7FFFFFFF;         // clear sign bit keep hash positive
        return hash % 100;

    }

    public Integer findAmountProbability(String userId, int num) {
        int hash = userId.hashCode() & 0x7FFFFFFF;         // clear sign bit keep hash positive
        return hash % num;

    }
}
