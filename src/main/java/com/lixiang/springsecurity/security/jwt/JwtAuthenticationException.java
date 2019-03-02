package com.lixiang.springsecurity.security.jwt;

import java.io.Serializable;

/**
 * @description: 自定义权限异常类
 * @author: lee
 * @create: 2019/03/02 15:53
 */

public class JwtAuthenticationException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -585712781295542843L;

    public JwtAuthenticationException() {
    }

    public JwtAuthenticationException(String message) {
        super(message);
    }

    public JwtAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public JwtAuthenticationException(Throwable cause) {
        super(cause);
    }

    public JwtAuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
