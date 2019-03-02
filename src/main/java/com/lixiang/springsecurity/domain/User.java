package com.lixiang.springsecurity.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description: 用户实体
 * @author: lee
 * @create: 2019/03/01 11:56
 * 1.创建用户类User(关联用户和角色)、角色类Role
 */
@Entity // 必选注解，声明这个类对应了一个数据库表。
@Table(name = "user") // 可选注解，声明数据库实体对应的表信息。包括表名称、索引信息。注意如果没有指定，则表名和实体的名称保持一致。
@Data //lombok插件 生成 setget方法
public class User implements Serializable {

    private static final long serialVersionUID = 456066897696124018L;

    @Id //声明了实体唯一标识对应的属性
    @GeneratedValue(strategy = GenerationType.AUTO) // 用于标注主键的生成策略，通过strategy 属性指定
    private Long id;

    @Column // 表示列 默认与属性对应，如不一致name属性定义了被标注字段在数据库表中所对应字段的名称；
    private String username;

    @Column
    private String password;

    @Column
    private Integer enabled;

    @Column(name = "last_pass_reset_date")
    private Date lastPassResetDate;

    @Column(name = "login_date")
    private Date loginDate;

    //关联角色表
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "relo_id")
    private List<Role> roles;


}
