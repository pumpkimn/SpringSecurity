package com.lixiang.springsecurity.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @description: 角色实体
 * @author: lee
 * @create: 2019/03/01 13:35
 */
@Entity
@Table(name = "role")
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 8979115730574774033L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;


}
