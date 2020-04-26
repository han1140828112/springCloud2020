package com.hzbs.payment.controller.action;


import com.hzbs.framework.commons.BaseAppController;
import com.hzbs.framework.commons.BaseResultResponse;
import com.hzbs.payment.entity.Payment;
import com.hzbs.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mr.wxh
 * @since 2020-04-25
 */
@Api("订单控制器")
@RestController
@RequestMapping("/payment")
public class PaymentAct extends BaseAppController {

    /**
     * <p>
     * 根据ID 查询订单
     * </p>
     * @param id: 订单ID
     * @return {@link BaseResultResponse< Boolean>}
     * @date 2020-04-25 19:19:50
     * @author Mr.Wxh
     * @since 0.1.0
     * @version 0.1.0
     */
    @ApiOperation("根据ID 查询订单")
    @GetMapping("/query/{id}")
    public BaseResultResponse<Payment> query(@ApiParam("1") @PathVariable("id") Integer id){
        return deal(()->paymentService.query(id));
    }

    /**
     * <p>
     * 新增订单
     * </p>
     *
     * @param payment:
     * @return {@link BaseResultResponse<Boolean>}
     * @date 2020-04-25 19:35:29
     * @author Mr.Wxh
     * @since 0.1.0
     * @version 0.1.0
     */
    @ApiOperation("新增订单")
    @PostMapping("/insert")
    public BaseResultResponse<Boolean> insert(@ApiParam("订单信息")@RequestBody Payment payment){
        return deal(()->paymentService.insert(payment));
    }

    @Autowired
    private PaymentService paymentService;
}

