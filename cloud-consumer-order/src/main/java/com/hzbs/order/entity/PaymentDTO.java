package com.hzbs.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 外部订单类DTO
 * </p>
 *
 * @author Mr.Wxh
 * @version 0.1.0
 * @date 2020-04-25 21:44
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PaymentDTO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    private String serial;


    public static final String ID = "id";

    public static final String SERIAL = "serial";
}