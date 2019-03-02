package com.lixiang.springsecurity.mapper;

import com.lixiang.springsecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 2.创建UserDao(注解：@Repository)，实现方法findByUsername()
 */
@Repository
public interface UserMapper extends JpaRepository<User,Long> {
    User findByUsername(String name);
}
