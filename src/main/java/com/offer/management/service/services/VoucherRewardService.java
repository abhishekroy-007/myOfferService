package com.offer.management.service.services;

import com.offer.management.service.entity.Offer;
import com.offer.management.service.entity.entityMeta.VoucherRewardMeta;
import com.offer.management.service.model.OfferRequest;
import com.offer.management.service.model.OfferType;
import com.offer.management.service.model.VoucherRewardType;
import com.offer.management.service.repository.OfferRepository;
import com.offer.management.service.repository.VoucherRewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherRewardService implements IOfferService {
    @Autowired
    VoucherRewardRepository voucherRewardRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    OfferValidatorService offerValidatorService;

    @Override
    public Offer createOffer(OfferRequest offerRequest) {
        VoucherRewardMeta voucherRewardMeta = VoucherRewardMeta.builder()
                .voucherRewardType(offerRequest.getVoucherRewardType())
                .voucherAmount(offerRequest.getVoucherAmount())
                .conditionalAmount(offerRequest.getConditionalAmount())
                .build();
        voucherRewardRepository.save(voucherRewardMeta);
        Offer offer = Offer.builder()
                .offerType(offerRequest.getOfferType())
                .brandId(offerRequest.getBrandId())
                .offerMetaId(voucherRewardMeta.getVoucherRewardMetaId())
                .build();
        offerRepository.save(offer);
        return offer;
    }

    @Override
    public String applyMaximumAvailableOffer(String userId, String brandId, String brandName, String currOrderAmount) {
        List<VoucherRewardMeta> offers = voucherRewardRepository.findAll();
        Long orderAmount = orderService.findOrderAmountInLastXdays(userId, 86400 * 30L);

        int amount = -1;
        String offerId = "";
        for (VoucherRewardMeta offer : offers) {
            if (offer.getVoucherRewardType().equals(VoucherRewardType.AMAZON_VOUCHER)
                    && (Long.parseLong(currOrderAmount) + orderAmount) >= Long.valueOf(offer.getConditionalAmount())
                    && offerValidatorService.isUserAllowedForThisOffer(userId, offer.getVoucherRewardMetaId())) {
                offerId = offer.getVoucherRewardMetaId();
            }
        }
        return offerId;
    }
}
