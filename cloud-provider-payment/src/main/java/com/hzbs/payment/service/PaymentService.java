package com.hzbs.payment.service;

import com.hzbs.payment.entity.Payment;

/**
 * <p>
 * 订单业务层
 * </p>
 *
 * @date 2020-04-25 19:20:57
 * @author Mr.Wxh
 * @since 0.1.0
 * @version 0.1.0
 */
public interface PaymentService {


    /**
     * <p>
     * 根据订单ID 查询订单
     * </p>
     * @return {@link }
     * @date 2020-04-25 19:22:27
     * @author Mr.Wxh
     * @since 0.1.0
     * @version 0.1.0
     */
    Payment query(Integer id);


    /**
     * <p>
     * 新增订单信息
     * </p>
     *
     * @param payment: 订单信息
     * @return {@link }
     * @date 2020-04-25 19:36:46
     * @author Mr.Wxh
     * @since 0.1.0
     * @version 0.1.0
     */
    Boolean insert(Payment payment);
}
