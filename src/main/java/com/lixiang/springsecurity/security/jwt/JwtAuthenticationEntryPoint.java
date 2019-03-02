package com.lixiang.springsecurity.security.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @description: 未授权 401 返回值
 * @author: lee
 * @create: 2019/03/02 15:55
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint,Serializable {
    private static final long serialVersionUID = -7316636564093091515L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) throws IOException, ServletException {
        //当用户尝试访问安全的REST资源而不提供任何凭据时，将调用此方法
        //我们应该发送401 Unauthorized响应，因为没有 可以重定向到“登录页面”
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
    }
}
