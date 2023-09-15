package com.offer.management.service.services;

import com.offer.management.service.entity.RewardValue;
import com.offer.management.service.exception.UserNotFoundException;
import com.offer.management.service.repository.RewardValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RewardValueService {
    @Autowired
    RewardValueRepository rewardValueRepository;

    public RewardValue findByUserId(String userId) {
        Optional<RewardValue> rewardValue = rewardValueRepository.findByUserId(userId);
        if(!rewardValue.isPresent()) {
            return null;
        }
        return rewardValue.get();
    }

    public void save(RewardValue rewardValue) {
        rewardValueRepository.save(rewardValue);
    }
}
