package com.coldsmog.luckinmap.model.dto;


import com.coldsmog.luckinmap.common.enums.ExceptionEnum;

/**
 * @Author: yongzhe.dong
 * @Date: 2019/10/30 13:21
 * @Description: 前端调用返回结果
 */
@SuppressWarnings("unchecked")
public class Result<T> {

    public final static int SUCCESS_CODE = 1;

    public final static int FAIL_CODE = 0;


    /**
     * 状态码
     */
    private int code;

    /**
     * 消息提示
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功时调用
     *
     * @return
     */
    public static Result success() {
        return new Result(SUCCESS_CODE, null, null);
    }

    public static <T> Result success(T data) {
        return new Result(SUCCESS_CODE, "", data);
    }

    public static Result fail(String message) {
        return new Result(FAIL_CODE, message, null);
    }

    public static Result fail(String message, Integer code) {
        return new Result(code, message, null);

    }

    public static Result fail(ExceptionEnum e) {
        return fail(e.getMsg(), e.getCode());

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
