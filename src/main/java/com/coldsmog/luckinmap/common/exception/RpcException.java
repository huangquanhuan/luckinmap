package com.coldsmog.luckinmap.common.exception;

/**
 * @Author: yongzhe.dong
 * @Date: 2019/11/2 11:28
 * @Description: rpc调用异常
 */
public class RpcException extends RuntimeException{

    /**
     * 错误信息
     */
    private String message;

    /**
     * rpc方法名
     */
    private String methodName;

    public RpcException(String message, String methodName) {
        this.message = message;
        this.methodName = methodName;
    }

    /**
     * 空参构造
     */
    public RpcException() {}

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
