package com.hzbs.payment.manager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzbs.payment.dao.IPaymentDao;
import com.hzbs.payment.entity.Payment;
import com.hzbs.payment.manager.IPaymentManager;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.wxh
 * @since 2020-04-25
 */
@Service
public class PaymentManagerImpl extends ServiceImpl<IPaymentDao, Payment> implements IPaymentManager {

}
