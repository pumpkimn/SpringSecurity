package com.lixiang.springsecurity.security.jwt;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @description: 权限不足(403)返回值
 * @author: lee
 * @create: 2019/03/02 15:58
 */
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler, Serializable {
    private static final long serialVersionUID = -4889062933243423069L;

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        //返回错误 403  被禁止的.
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
    }
}
