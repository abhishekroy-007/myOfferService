package com.offer.management.service.services;

import com.offer.management.service.Factory.OfferServiceFactory;
import com.offer.management.service.entity.Brand;
import com.offer.management.service.entity.Order;
import com.offer.management.service.model.OfferType;
import com.offer.management.service.model.OrderRequest;
import com.offer.management.service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private OfferServiceFactory offerServiceFactory;

    @Autowired
    BrandService brandService;

    public Order markOrderCompletedPostPaymentWithOfferApplied(OrderRequest orderRequest) {
        Brand brand = brandService.getBrandById(orderRequest.getBrandId());
        // Applied Priority Logic For CashBackOffer
        String offerAppliedId = checkAndApplyCashbackOffer(orderRequest.getUserId(), brand.getId(), brand.getBrandName(), orderRequest.getOrderAmount());
        if(offerAppliedId.isEmpty()){
            offerAppliedId = offerAppliedId + "," + checkAndApplyRewardPointOffer(orderRequest.getUserId(), brand.getId(), brand.getBrandName(), orderRequest.getOrderAmount());
            offerAppliedId = offerAppliedId + "," + checkAndApplyVoucherRewardOffer(orderRequest.getUserId(), brand.getId(), brand.getBrandName(), orderRequest.getOrderAmount());
        }
        Order order = createOrder(orderRequest, offerAppliedId);
        return orderRepository.save(order);
    }

    protected Long findOrderAmountInLastXdays(String userId, long time) {
        List<Order> orders = orderRepository.findByUserId(userId);
        Long orderAmount = 0L;
        Long currTime = new Date().getTime();
        for (Order order : orders){
            if(currTime - Long.valueOf(order.getCreatedOn())<=time) {
                orderAmount += Long.valueOf(order.getOrderAmount());
            }
        }
        return  orderAmount;
    }

    protected Long findOrderAmountForBrandInLastXDays(String userid, String brandId, long time) {
        List<Order> orders = orderRepository.findByUserIdAndBrandId(userid, brandId); // Query Can Be Optimised
        Long orderAmount = 0L;
        Long currTime = new Date().getTime();
        for (Order order : orders){
            if(currTime - Long.valueOf(order.getCreatedOn())<=time) {
                orderAmount += Long.valueOf(order.getOrderAmount());
            }
        }
        return  orderAmount;
    }

    private Order createOrder(OrderRequest orderRequest, String offerAppliedId) {
        Order order = Order.builder()
                .createdOn(String.valueOf(new Date().getTime()))
                .updatedOn(String.valueOf(new Date().getTime()))
                .brandId(orderRequest.getBrandId())
                .paymentId(orderRequest.getPaymentId())
                .userId(orderRequest.getUserId())
                .orderStatus("COMPLETED")
                .orderAmount(orderRequest.getOrderAmount())
                .build();
        // The above entry will already be their in db once payment was in some other state post payment completion ,
        // here we would be updating  offer Id which would be null till now
        // As offer Details are being set post payment
        order.setOfferId(offerAppliedId);
        orderRepository.save(order);
        return order;
    }

    private String checkAndApplyCashbackOffer(String userId, String brandId, String brandName, String orderAmount) {
        IOfferService offerService = offerServiceFactory.get(String.valueOf(OfferType.CASHBACK_REWARD));
        return offerService.applyMaximumAvailableOffer(userId, brandId, brandName, orderAmount);
    }

    private String checkAndApplyRewardPointOffer(String userId, String brandId, String brandName, String orderAmount) {
        IOfferService offerService = offerServiceFactory.get(String.valueOf(OfferType.REWARD_POINTS));
        return offerService.applyMaximumAvailableOffer(userId, brandId, brandName, orderAmount);
    }

    private String checkAndApplyVoucherRewardOffer(String userId, String brandId, String brandName, String orderAmount) {
        IOfferService offerService = offerServiceFactory.get(String.valueOf(OfferType.VOUCHER_REWARD));
        return offerService.applyMaximumAvailableOffer(userId, brandId, brandName, orderAmount);
    }



}
