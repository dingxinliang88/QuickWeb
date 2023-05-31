package com.juzi.quickweb.exception;

import com.juzi.quickweb.common.BaseResponse;
import com.juzi.quickweb.common.StatusCode;
import com.juzi.quickweb.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 *
 * @author codejuzi
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException businessException) {
        log.error("BusinessException: ", businessException);
        return ResultUtils.error(businessException.getCode(), businessException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<?> otherExceptionHandler(Exception e) {
        log.error("Exception: ", e);
        return ResultUtils.error(StatusCode.SYSTEM_ERROR);
    }
}
