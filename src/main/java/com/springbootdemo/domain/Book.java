package com.springbootdemo.domain;

import java.util.Date;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:
 *
 * @author 002864
 * @created 2018/11/22 17:00
 * @since v1.0.0
 */
@Entity
@Table(name = "test_book")
@Data
public class Book {

    @Id
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 时间
     */
    private Date   publishTime;
}
