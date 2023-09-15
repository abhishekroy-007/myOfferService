package com.offer.management.service.services;

import com.offer.management.service.entity.Brand;
import com.offer.management.service.exception.BrandNotFoundException;
import com.offer.management.service.model.BrandRequest;
import com.offer.management.service.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public Brand createBrand(BrandRequest brandRequest) {
        Brand brand = Brand.builder()
                .brandName(brandRequest.getName())
                .build();
        return brandRepository.save(brand);
    }

    public Brand getBrand(String brandName) {
        Optional<Brand> brand = brandRepository.findByBrandName(brandName);
        if (!brand.isPresent()) {
            throw new BrandNotFoundException("Brand Not Found By Name Exception");
        }
        return brand.get();
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(String brandId) {
        Optional<Brand> brand = brandRepository.findById(brandId);
        if (!brand.isPresent()) {
            throw new BrandNotFoundException("Brand Not Found By Id Exception");
        }
        return brand.get();
    }
}
