package com.offer.management.service.repository;

import com.offer.management.service.entity.entityMeta.VoucherRewardMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRewardRepository extends JpaRepository<VoucherRewardMeta, String> {
}
