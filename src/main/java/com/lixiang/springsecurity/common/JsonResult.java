package com.lixiang.springsecurity.common;

/**
 * @description: 统一JSON返回出口
 * @author: lee
 * @create: 2019/02/14 10:40
 */
public class JsonResult {
    private static final Integer SUCCESS_STATUS = 200;
    private static final Integer FAILURE_STATUS = 400;
    private static final Integer INTERNAL_ERROR_STATUS = 500;
    private static final String SUCCESS_MESSAGE = "操作成功";//success
    private static final String ERROR_MESSAGE = "操作失败";//failure
    private static final String MESSAGE_EMPTY_RESPONSE = "返回数据为空";
    private static final String INTERNAL_ERROR_MESSAGE = "服务器内部错误";//internal error

    //状态码
    private Integer status;
    //消息
    private String msg;
    //数据
    private Object data;
    //判断是否成功
    private Boolean success;


    private JsonResult(Integer status, String msg, Object data, Boolean success) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.success = success;
    }


    public static JsonResult success() {
        return new JsonResult(SUCCESS_STATUS, SUCCESS_MESSAGE, null, Boolean.TRUE);
    }

    public static JsonResult success(Object data) {
        if (data == null) {
            error(MESSAGE_EMPTY_RESPONSE);
        }
        return new JsonResult(SUCCESS_STATUS, SUCCESS_MESSAGE, data, Boolean.TRUE);
    }

    public static JsonResult error() {
        return new JsonResult(FAILURE_STATUS, ERROR_MESSAGE, null, Boolean.FALSE);
    }

    public static JsonResult error(String msg) {
        return new JsonResult(FAILURE_STATUS, msg, null, Boolean.FALSE);
    }

    public static JsonResult internalError() {
        return new JsonResult(INTERNAL_ERROR_STATUS, INTERNAL_ERROR_MESSAGE, null, Boolean.FALSE);
    }

    public static JsonResult internalError(String msg) {
        return new JsonResult(INTERNAL_ERROR_STATUS, msg, null, Boolean.FALSE);
    }

    public static JsonResult customize(Integer status, String msg, Object obj, Boolean flag) {
        return new JsonResult(status, msg, obj, flag);
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
