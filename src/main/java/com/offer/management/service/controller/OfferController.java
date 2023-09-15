package com.offer.management.service.controller;

import com.offer.management.service.Factory.OfferServiceFactory;
import com.offer.management.service.entity.Offer;
import com.offer.management.service.model.OfferRequest;
import com.offer.management.service.services.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OfferController implements IOfferController {

    @Autowired
    private OfferServiceFactory offerServiceFactory;

    @Override
    public ResponseEntity<Offer> createOffer(OfferRequest offerRequest) {
        IOfferService offerService = offerServiceFactory.get(String.valueOf(offerRequest.getOfferType()));
        Offer offer = offerService.createOffer(offerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(offer);
    }
}
