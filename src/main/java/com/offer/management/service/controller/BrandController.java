package com.offer.management.service.controller;

import com.offer.management.service.entity.Brand;
import com.offer.management.service.model.BrandRequest;
import com.offer.management.service.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandController implements IBrandController{

    @Autowired
    BrandService brandService;

    @Override
    public ResponseEntity<Brand> createBrand(BrandRequest brandRequest) {
        Brand brand = brandService.createBrand(brandRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(brand);
    }

    @Override
    public ResponseEntity<Brand> getBrand(String brandName) {
        Brand brand = brandService.getBrand(brandName);
        return ResponseEntity.status(HttpStatus.OK).body(brand);
    }

    @Override
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brand = brandService.getAllBrands();
        return ResponseEntity.status(HttpStatus.OK).body(brand);
    }
}
