package com.lixiang.springsecurity.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: JWT 过滤器
 * @author: lee
 * @create: 2019/03/01 14:28
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String jwtHeader;

    @Value("${jwt.token.head}")
    private String tokenHead;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //获取请求头部内容
        String requestHeaderToken = request.getHeader(jwtHeader);
        if (requestHeaderToken!= null && requestHeaderToken.startsWith(tokenHead)){
            //获取令牌 （头部里面后半部分）
            String authToken = requestHeaderToken.substring(tokenHead.length());
            //从令牌里面获得用户名
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            if (username!= null && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails user = userDetailsService.loadUserByUsername(username);
                //根据用户名获得安全用户对象
                if (jwtTokenUtil.validateToken(authToken,user)){
                    //生成通过认证
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),user.getAuthorities());
                    //加载额外数据源参数，如验证码等等.
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    //将权限写入本次绘画
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}

//客户端将token封装在请求头中，格式为（Bearer后加空格），Authorization:Bearer +token
//SecurityContextHolder.getContext().getAuthenization() 则表示用户尚未登陆.