package com.offer.management.service.controller;

import com.offer.management.service.entity.Brand;
import com.offer.management.service.model.BrandRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IBrandController {
    @PostMapping("/v1/createBrand")
    public ResponseEntity<Brand> createBrand(@RequestBody BrandRequest brandRequest);

    @GetMapping("/v1/getBrand")
    public ResponseEntity<Brand> getBrand(@RequestParam String brandName);

    @GetMapping("/v1/getAllBrands")
    public ResponseEntity<List<Brand>> getAllBrands();
}
