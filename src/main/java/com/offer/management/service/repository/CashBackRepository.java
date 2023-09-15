package com.offer.management.service.repository;

import com.offer.management.service.entity.entityMeta.CashBackMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashBackRepository extends JpaRepository<CashBackMeta, String>  {
    List<CashBackMeta> findByBrandName(String brandName);
}
