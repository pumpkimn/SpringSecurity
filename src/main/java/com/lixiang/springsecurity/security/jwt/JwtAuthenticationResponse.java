package com.lixiang.springsecurity.security.jwt;

import java.io.Serializable;

/**
 * @description: 授权响应类
 * @author: lee
 * @create: 2019/03/02 15:43
 */
public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 6426880898329041911L;

    private String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
