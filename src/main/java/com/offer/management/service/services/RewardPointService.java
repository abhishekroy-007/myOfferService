package com.offer.management.service.services;

import com.offer.management.service.entity.Offer;
import com.offer.management.service.entity.RewardValue;
import com.offer.management.service.entity.entityMeta.RewardPointMeta;
import com.offer.management.service.model.OfferRequest;
import com.offer.management.service.model.OfferType;
import com.offer.management.service.model.RewardPointType;
import com.offer.management.service.repository.OfferRepository;
import com.offer.management.service.repository.RewardPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardPointService implements IOfferService {

    @Autowired
    RewardPointRepository rewardPointRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    RewardValueService rewardValueService;

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    OfferValidatorService offerValidatorService;

    @Override
    public Offer createOffer(OfferRequest offerRequest) {
        RewardPointMeta rewardPointMeta = RewardPointMeta.builder()
                .rewardPointType(offerRequest.getRewardPointType())
                .rewardPointAwarded(offerRequest.getRewardPointAwarded())
                .moneyToBeSpent(offerRequest.getMoneyToBeSpent())
                .build();
        rewardPointRepository.save(rewardPointMeta);
        Offer offer = Offer.builder()
                .offerType(offerRequest.getOfferType())
                .brandId(offerRequest.getBrandId())
                .offerMetaId(rewardPointMeta.getRewardPointMetaId())
                .build();
        offerRepository.save(offer);
        return offer;
    }

    @Override
    public String applyMaximumAvailableOffer(String userId, String brandId, String brandName, String currOrderAmount) {
        List<RewardPointMeta> offers = rewardPointRepository.findAll();

        RewardValue rewardValue = rewardValueService.findByUserId(userId);
        if (rewardValue == null) {
            rewardValue = RewardValue.builder()
                    .rewardValue(0)
                    .userId(userId)
                    .build();
        }
        String offerId = "";
        for (RewardPointMeta offer : offers) {
            if (offer.getRewardPointType().equals(RewardPointType.POINT_BASED)
                    && !brandName.equalsIgnoreCase(offer.getBrandTypesToNotAllow()) && offerValidatorService.isUserAllowedForThisOffer(userId, offer.getRewardPointMetaId())) {
                Integer reward = (Integer.valueOf(currOrderAmount)/Integer.parseInt(offer.getMoneyToBeSpent())) * Integer.parseInt(offer.getRewardPointAwarded());
                rewardValue.setRewardValue(rewardValue.getRewardValue() + reward);
                rewardValueService.save(rewardValue);
                offerId = offer.getRewardPointMetaId();
            }
        }
        return offerId;
    }


}
