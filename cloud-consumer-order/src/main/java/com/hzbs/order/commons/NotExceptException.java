package com.hzbs.order.commons;

/**
 * <p>
 * 不期望发生的异常类
 * </p>
 *
 * @author Mr.Wxh
 * @version 0.11.0
 * @date 2020-02-06 00:24
 **/
public class NotExceptException extends RuntimeException {
    private static final long serialVersionUID = -1561152563467810817L;

    public NotExceptException(String msg,Exception e){
        super(msg,e);
    }

    public NotExceptException(String msg){
        super(msg);
    }

    public NotExceptException(){
        this("不期望发生的异常");
    }
}