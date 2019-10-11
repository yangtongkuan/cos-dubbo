package com.cos.common.exception;

import com.cos.cloud.common.tools.AjaxResult;
import com.cos.cloud.user.model.custom_exc.UnKnowSysCustomerException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 *
 * @desc: 全局异常处理类
 * @User: @Created by yangtk
 * @Date: @Date 2019/8/11 17:00
 * @To change this template use File | Settings | File Templates.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 未知的客户端异常
    @ExceptionHandler({UnKnowSysCustomerException.class})
    public String globalExceptionHandler(Exception e) {
        return AjaxResult.errorResult(e.getMessage());
    }
}
