package com.lq.plat.link;

import org.springframework.http.HttpStatus;


/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public enum PlatformStatus {

    S200(HttpStatus.OK,200,"请求成功"),

    S40100(HttpStatus.BAD_REQUEST, 40100,"缺少参数"),

    S40101(HttpStatus.BAD_REQUEST,40101,"参数所带值错误"),

    S40001(HttpStatus.UNAUTHORIZED, 40001,"Unauthorized"),

    S40003(HttpStatus.FORBIDDEN,40003,"Forbidden"),

    S40004(HttpStatus.NOT_FOUND, 40004,"Not Found"),

    S40005(HttpStatus.REQUEST_TIMEOUT,40005,"操作超时,请重试"),

    S40006(HttpStatus.NOT_ACCEPTABLE, 40006,"Not Support"),

    S50000(HttpStatus.INTERNAL_SERVER_ERROR,50000,"Internal Server Error"),

    S50002(HttpStatus.BAD_GATEWAY, 50002,"Bad Gateway"),

    S41001(HttpStatus.OK,41001,"用户名或者密码错误"),

    S41002(HttpStatus.OK, 41002,"用户已存在"),

    S41003(HttpStatus.OK,41003,"不支持的文件类型"),

    S41004(HttpStatus.OK, 41004,"已超过最大的允许值"),

    S41005(HttpStatus.OK,41005,"尚未发布"),

    S42001(HttpStatus.OK, 42001,"不被允许更改的状态值"),

    S42002(HttpStatus.OK,42002,"不允许删除"),

    S43001(HttpStatus.OK, 43001,"操作不成功,请重试."),

    S49001(HttpStatus.OK,49001,"openId is null"),

    S49002(HttpStatus.OK, 49002,"微信验证不成功,请重新打开进行页面");

    private final int errcode;
    private final String errmsg;
    private final HttpStatus httpStatus;

    private PlatformStatus(HttpStatus httpStatus, int errcode, String errmsg) {
        this.httpStatus = httpStatus;
        this.errcode = errcode;
        this.errmsg = errmsg;
    }


    public int getErrcode() {
        return this.errcode;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

}
