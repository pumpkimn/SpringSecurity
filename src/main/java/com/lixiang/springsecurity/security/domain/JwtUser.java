package com.lixiang.springsecurity.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @description: 安全用户模型
 * @author: lee
 * @create: 2019/03/01 13:50
 * 3.创建安全用户类JwtUser(关联安全用户和权限)，实现UserDetails接口
 */
public class JwtUser implements UserDetails,Serializable {
    private static final long serialVersionUID = 1310217870012910819L;

    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private Date lastPasswordResetDate;
    private Date loginDate;
    // 关联安全用户和权限
    private List<GrantedAuthority> authorities;

    public JwtUser(Long id, String username, String password, boolean enabled, Date lastPasswordResetDate, Date loginDate, List<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.loginDate = loginDate;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override ////账户是否过期,过期无法验证
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override //指定用户是否被锁定或者解锁,锁定的用户无法进行身份验证
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override //指示是否已过期的用户的凭据(密码),过期的凭据防止认证
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override //是否被禁用,禁用的用户不能身份验证
    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    @JsonIgnore
    public Date getLoginDate() {
        return loginDate;
    }
}
