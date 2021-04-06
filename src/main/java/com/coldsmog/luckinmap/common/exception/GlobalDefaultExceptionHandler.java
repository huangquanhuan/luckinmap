package com.coldsmog.luckinmap.common.exception;


import com.coldsmog.luckinmap.model.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

/**
 * @Author: yongzhe.dong
 * @Date: 2019/11/2 11:39
 * @Description: 全局异常处理类
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    /**
     * 全局异常
     *
     * @param request 请求
     * @param e       异常
     * @return Result 错误结果
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result exception(HttpServletRequest request, Exception e) {
        LOGGER.error(request.getRequestURI() + " 请求异常");
        LOGGER.error("未捕获异常，错误信息：", e);
        return Result.fail("系统错误");
    }

    /**
     * 自定义业务异常
     *
     * @param request 请求
     * @param e       异常
     * @return 错误结果
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Result bizExceptionHandler(HttpServletRequest request, BusinessException e) {
        LOGGER.error(request.getRequestURI() + " 请求出现业务异常");
        LOGGER.error("业务异常信息：{}", e.getMsg());
        return Result.fail(e.getMsg(),e.getCode());
    }

    /**
     * 自定义远程调用异常
     *
     * @param request 请求
     * @param e       异常
     * @return 错误结果
     */
    @ResponseBody
    @ExceptionHandler(value = RpcException.class)
    public Result remoteExceptionHandler(HttpServletRequest request, RpcException e) {
        LOGGER.error(request.getRequestURI() + " 请求出现rpc异常");
        LOGGER.error("远程调用：{}异常，异常信息：{}，异常：", e.getMethodName(), e.getMessage(), e);
        return Result.fail(e.getMessage());
    }

    /**
     * 404异常
     *
     * @param request 请求
     * @param e       异常
     * @return 错误结果
     */
    @ResponseBody
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Result resolveException(HttpServletRequest request, Exception e) {
        LOGGER.error(request.getRequestURI() + " 请求未找到");
        LOGGER.error("错误信息：", e);
        return Result.fail(request.getRequestURI() + " 请求未找到");
    }

    /**
     * 绑定异常
     *
     * @param request 请求
     * @param e       异常
     * @return Result 错误结果
     */
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public Result bindException(HttpServletRequest request, BindException e) {
        LOGGER.error(request.getRequestURI() + " 请求参数异常");
        LOGGER.error("错误信息：", e);
        String message = e.getMessage();
        //抛出错误异常
        return Result.fail(message);
    }


}
