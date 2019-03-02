package com.lixiang.springsecurity.security.jwt;

import java.io.Serializable;

/**
 * @description: 授权请求类
 * @author: lee
 * @create: 2019/03/02 15:45
 */
public class JwtAuthenticationRequest  implements Serializable {
    private static final long serialVersionUID = -2943002656686041962L;

    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
