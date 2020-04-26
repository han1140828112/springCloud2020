package com.hzbs.order.controller.action;

import com.hzbs.framework.commons.BaseAppController;
import com.hzbs.framework.commons.BaseResultResponse;
import com.hzbs.order.entity.PaymentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>
 * 订单模块消费者
 * </p>
 *
 * @author Mr.Wxh
 * @version 0.1.0
 * @date 2020-04-25 21:45
 **/
@RestController
@Slf4j
public class OrderAction extends BaseAppController {
    private static final String PAYMENT_URL = "http://localhost:17200";


    /**
     * <p>
     * 插入一条数据
     * </p>
     *
     * @return {@link }
     * @date 2020-04-25 22:32:03
     * @author Mr.Wxh
     * @since 0.1.0
     * @version 0.1.0
     */
    @GetMapping("/consumer/insert")
    public BaseResultResponse<Boolean> insert(PaymentDTO paymentDTO){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/insert",paymentDTO,BaseResultResponse.class);
    }

    @GetMapping("/query/{id}")
    public BaseResultResponse<PaymentDTO> query(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/query/"+id,BaseResultResponse.class);
    }
    @Resource
    private RestTemplate restTemplate;
}