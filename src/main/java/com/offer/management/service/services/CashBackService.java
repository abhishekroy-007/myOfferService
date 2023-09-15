package com.offer.management.service.services;

import com.offer.management.service.entity.Offer;
import com.offer.management.service.entity.entityMeta.CashBackMeta;
import com.offer.management.service.model.CashBackType;
import com.offer.management.service.model.OfferRequest;
import com.offer.management.service.model.OfferType;
import com.offer.management.service.repository.CashBackRepository;
import com.offer.management.service.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashBackService implements IOfferService {
    @Autowired
    CashBackRepository cashBackRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    ProbabilityService probabilityService;

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    OfferValidatorService offerValidatorService;

    @Override
    public Offer createOffer(OfferRequest offerRequest) {
        CashBackMeta cashBackMeta = CashBackMeta.builder()
                .cashBackType(CashBackType.PROBABILISTIC_DISCOUNT)
                .discountValueOnCondition("{}")
                .brandName(offerRequest.getBrandName())
                .build();
        cashBackRepository.save(cashBackMeta);
        Offer offer = Offer.builder()
                .offerType(offerRequest.getOfferType())
                .brandId(offerRequest.getBrandId())
                .offerMetaId(cashBackMeta.getCashBackMetaId())
                .build();
        offerRepository.save(offer);
        return offer;
    }

    @Override
    public String applyMaximumAvailableOffer(String userId,String brandId, String brandName, String currOrderAmount) {
        List<CashBackMeta> offers = cashBackRepository.findAll();
        Long orderAmount = orderService.findOrderAmountInLastXdays(userId, 86400*30L);

        int amount = -1;
        String offerId = "";
        for (CashBackMeta offer : offers) {
            if (brandName.equalsIgnoreCase("ZOMATO")
                    && offerValidatorService.isUserAllowedForThisOffer(userId, offer.getCashBackMetaId())) {
                int offerAmount = checkZomatoOffer(userId);
                offerId = applyOffer(offerId, amount, offer.getCashBackMetaId(), offerAmount);
            } else if (brandName.equalsIgnoreCase("SWIGGY")
                    && offerValidatorService.isUserAllowedForThisOffer(userId, offer.getCashBackMetaId())) {
                int offerAmount = checkSwiggyOffer(userId, brandId, currOrderAmount);
                offerId =applyOffer(offerId, amount, offer.getCashBackMetaId(), offerAmount);
            } else if (orderAmount >= 10000L
                    && offerValidatorService.isUserAllowedForThisOffer(userId, offer.getCashBackMetaId())) {
                offerId = applyOffer(offerId, amount, offer.getCashBackMetaId(), 500);
            } else if (brandName.equalsIgnoreCase("ZARA")
                    && offerValidatorService.isUserAllowedForThisOffer(userId, offer.getCashBackMetaId())) {
                int offerAmount = checkZaraOffer(currOrderAmount);
                offerId = applyOffer(offerId, amount, offer.getCashBackMetaId(), offerAmount);
            } else if (brandName.equalsIgnoreCase("PETROLPUMP")
                    && offerValidatorService.isUserAllowedForThisOffer(userId, offer.getCashBackMetaId())) {
                int offerAmount = checkPetrolPumpOffer(currOrderAmount);
                offerId = applyOffer(offerId, amount, offer.getCashBackMetaId(), offerAmount);
            }
        }
        return offerId;
    }

    private int checkPetrolPumpOffer(String currOrderAmount) {
        Double amount = (Double.valueOf(currOrderAmount) * 2.0) / 100;
        return Integer.valueOf(String.valueOf(amount));
    }

    private int checkZaraOffer(String currOrderAmount) {
        if (Long.valueOf(currOrderAmount) >= 100L && Long.valueOf(currOrderAmount) <= 500L) {
            return 10;
        } else if (Long.valueOf(currOrderAmount) >= 501 && Long.valueOf(currOrderAmount) <= 1000L) {
            return 50;
        } else {
            return 100;
        }
    }

    private int checkSwiggyOffer(String userId, String brandId, String currOrderAmount) {
        Long orderAmountInLast1day = orderService.findOrderAmountForBrandInLastXDays(userId, brandId, 86400L);
        Long orderAmountInLast30day = orderService.findOrderAmountForBrandInLastXDays(userId, brandId, 86400 * 30L);
        return (orderAmountInLast30day <= 2500L && orderAmountInLast1day <= 500L && Long.valueOf(currOrderAmount) > 500L) ? 100 : 0;
    }

    private int checkZomatoOffer(String userId) {
        int probability = probabilityService.findProbabilityService(userId);
        if (probability <= 50) {
            return probabilityService.findAmountProbability(userId, 10);
        } else if (probability <= 75) {
            int amount = -1;
            while (amount <= 10) {
                amount = probabilityService.findAmountProbability(userId, 25);
            }
            return amount;
        } else {
            int amount = -1;
            while (amount <= 25) {
                amount = probabilityService.findAmountProbability(userId, 100);
            }
            return amount;
        }
    }

    private String applyOffer(String offerId, int amount, String cashBackMetaId, int offerAmount) {
        if (offerAmount > amount) {
            return cashBackMetaId;
        }
        return offerId;
    }
}
