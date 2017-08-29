package com.lq.plat.link.security;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/13
 */
public class FailResponse {

    private String message;

    public FailResponse() {
    }

    public FailResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
