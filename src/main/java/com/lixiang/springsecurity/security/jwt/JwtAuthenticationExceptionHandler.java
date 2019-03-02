package com.lixiang.springsecurity.security.jwt;

import com.lixiang.springsecurity.common.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import java.io.Serializable;

/**
 * @description: 自定义异常处理类
 * @author: lee
 * @create: 2019/03/02 15:46
 */
@ControllerAdvice// 注解定义全局异常处理类
public class JwtAuthenticationExceptionHandler implements Serializable {
    private static final long serialVersionUID = -6339605093400744603L;

    @ExceptionHandler(AuthenticationException.class)
    private ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

}
