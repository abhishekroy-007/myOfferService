package com.offer.management.service.repository;

import com.offer.management.service.entity.RewardValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RewardValueRepository extends JpaRepository<RewardValue, String> {
    Optional<RewardValue> findByUserId(String userId);
}
