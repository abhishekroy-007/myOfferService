package com.offer.management.service.Factory;

import com.offer.management.service.model.OfferType;
import com.offer.management.service.services.CashBackService;
import com.offer.management.service.services.IOfferService;
import com.offer.management.service.services.RewardPointService;
import com.offer.management.service.services.VoucherRewardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OfferServiceFactory {
    @Autowired
    ApplicationContext applicationContext;

    public IOfferService get(String offerType) {

        if (offerType.equals(OfferType.REWARD_POINTS.name())) {
            return applicationContext.getBean(RewardPointService.class);
        } else if (offerType.equals(OfferType.CASHBACK_REWARD.name())) {
            return applicationContext.getBean(CashBackService.class);
        } else if (offerType.equals(OfferType.VOUCHER_REWARD.name())) {
            return applicationContext.getBean(VoucherRewardService.class);
        }
        return  null;
    }
}
