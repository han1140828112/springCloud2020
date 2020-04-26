package com.hzbs.framework.commons;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

/**
 * <p>
 * Controller基类
 * </p>
 *
 * @author Mr.Wxh
 * @version 0.11.0
 * @date 2020-02-16 14:13
 **/
@Slf4j
public class  BaseAppController {
    private static final String NOT_KNOW_MSG = "不期望发生的异常";

    protected <T> BaseResultResponse<T> deal(Supplier<T> impl){
        BaseResultResponse<T> result = new BaseResultResponse<>();
        try {
            return result.initSuccess(impl.get());
        } catch (NotExceptException e) {
            log.warn("发生错误,原因:{}", e.getMessage());
            return result.initFailure(e.getMessage());
        } catch (Exception e){
            log.warn("发生错误", e);
            return result.initFailure(NOT_KNOW_MSG);
        }
    }
}