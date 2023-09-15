package com.offer.management.service.controller;

import com.offer.management.service.entity.Offer;
import com.offer.management.service.model.OfferRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IOfferController {
    @PostMapping("/v1/createOffer")
    public ResponseEntity<Offer> createOffer(@RequestBody OfferRequest offerRequest);

}
