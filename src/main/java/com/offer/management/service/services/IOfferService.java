package com.offer.management.service.services;

import com.offer.management.service.entity.Offer;
import com.offer.management.service.model.OfferRequest;

public interface IOfferService {

    Offer createOffer(OfferRequest offerRequest);


    String applyMaximumAvailableOffer(String userId, String BrandId, String BrandName, String orderAmount);
}
