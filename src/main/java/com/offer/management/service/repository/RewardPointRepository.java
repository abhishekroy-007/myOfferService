package com.offer.management.service.repository;

import com.offer.management.service.entity.entityMeta.RewardPointMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardPointRepository extends JpaRepository<RewardPointMeta, String>  {
}
