package com.lixiang.springsecurity.security.service;

import com.lixiang.springsecurity.domain.User;
import com.lixiang.springsecurity.mapper.UserMapper;
import com.lixiang.springsecurity.security.domain.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @description: 安全用户服务
 * @author: lee
 * @create: 2019/03/01 14:07
 *
 * 5.创建JwtUserService(注解：@Service)，实现UserDetailsService接口，重写loadByUsername()方法
 */
@Service
public class JwtUserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if (username == null) {
            throw new UsernameNotFoundException("用户名未找到例外");
        }
        return JwtUserFactory.createJwtUser(user);
    }
}
