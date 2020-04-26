package com.hzbs.payment.service.impl;

import com.hzbs.payment.entity.Payment;
import com.hzbs.payment.manager.IPaymentManager;
import com.hzbs.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单类
 * </p>
 *
 * @author Mr.Wxh
 * @version 0.1.0
 * @date 2020-04-25 19:21
 **/
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Payment query(Integer id) {
        return paymentManager.getById(id);
    }

    @Override
    public Boolean insert(Payment payment) {
        return paymentManager.save(payment);
    }

    @Autowired
    private IPaymentManager paymentManager;
}