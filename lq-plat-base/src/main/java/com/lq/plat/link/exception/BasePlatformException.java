package com.lq.plat.link.exception;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class BasePlatformException extends RuntimeException
{
    private static final long serialVersionUID = -6453040625720373585L;

    public BasePlatformException() {
    }

    public BasePlatformException(String message) {
        super(message);
    }
}