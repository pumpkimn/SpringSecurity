package com.lixiang.springsecurity.controller;

import com.lixiang.springsecurity.security.domain.JwtUser;
import com.lixiang.springsecurity.security.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @description: 用户登录控制器
 * @author: lee
 * @create: 2019/03/02 16:01
 */
@RestController
@RequestMapping("api")
public class UserLoginController {

    @Value("${jwt.header}")
    private String jwtHeader;

    @Value("${jwt.token.head}")
    private String tokenHeader;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        // 1.从请求头中获得令牌
        String token = request.getHeader(jwtHeader).substring(tokenHeader.length());
        // 2.从令牌中获得用户信息
        String username = jwtTokenUtil.getUsernameFromToken(token);
        // 3.将用户信息返回页面
        return (JwtUser) userDetailsService.loadUserByUsername(username);
    }
}
