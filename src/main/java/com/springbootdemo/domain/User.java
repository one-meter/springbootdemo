package com.springbootdemo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:
 *
 * @author 002864
 * @created 2018/5/24 14:45
 * @since v1.0.0
 */
@Entity
@Table(name = "test_user")
@Data
public class User {

    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 姓名
     */
    private String  name;

    /**
     * 密码
     */
    private String  password;

}
