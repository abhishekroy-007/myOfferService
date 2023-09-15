package com.offer.management.service.repository;

import com.offer.management.service.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, String> {
    Optional<Brand> findByBrandName(String brandName);
}
