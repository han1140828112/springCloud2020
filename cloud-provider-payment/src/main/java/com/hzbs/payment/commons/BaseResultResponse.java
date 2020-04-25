package com.hzbs.payment.commons;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName BaseResultResponse
 * <p>
 *
 * </p>
 * @Author Mr.Wxh
 * @Date 2020/2/1 8:17 下午
 */
@Data
public class BaseResultResponse<T> implements Serializable {

    private static final long serialVersionUID = 3919282650786039703L;
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String message;

    public BaseResultResponse() {}

    public BaseResultResponse(Boolean success){
        super();
        this.success = success;
    }

    public BaseResultResponse(Boolean success,String message){
        super();
        this.success = success;
        this.message = message;
    }

    public BaseResultResponse(Boolean success,T data){
        super();
        this.success = success;
        this.data = data;
    }

    public BaseResultResponse<T> initSuccess(T data){
        this.success = true;
        this.data = data;
        return this;
    }

    public BaseResultResponse<T> initFailure(String message){
        this.success = false;
        this.message = message;
        return this;
    }

    public static<T> T getResponseData(BaseResultResponse<T> response){
        if(response != null && response.getSuccess() != null && response.getSuccess()){
            return response.getData();
        }
        return null;
    }
}
