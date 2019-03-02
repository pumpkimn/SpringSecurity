package com.lixiang.springsecurity.security.domain;

import com.lixiang.springsecurity.domain.Role;
import com.lixiang.springsecurity.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 用户安全工厂
 * @author: lee
 * @create: 2019/03/01 13:57
 * <p>
 * 4.创建JwtUserFactory工具类(关联角色和权限)，实现由User向JwtUser类对象的转换
 */
public class JwtUserFactory {
    /**
     * 将用户 与 安全用户关联起来
     *
     * @param user 用户
     * @return JwtUser 安全用户
     */
    public static JwtUser createJwtUser(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEnabled() == 1,
                user.getLastPassResetDate(),
                user.getLoginDate(),
                roleToAuthority(user.getRoles())
        );
    }

    /**
     * 将用户的角色与权限关联起来
     *
     * @param roles 角色集合
     * @return GrantedAuthority 权限集合 赋予权限
     */
    private static List<GrantedAuthority> roleToAuthority(List<Role> roles) {
        return roles.stream()
                .map(e -> new SimpleGrantedAuthority(e.getName()))
                .collect(Collectors.toList());
    }
}
