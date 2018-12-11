package com.bizfocus.consulservice.customer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-06 13:30
 **/
@Entity
@Table(name = "customer")
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "createtime")
    private Date createTime;

    @Column(name = "createby")
    private long createBy;

    @Column(name = "updatetime")
    private Date updateTime;

    @Column(name = "updateby")
    private long updateBy;

    @Column(name = "isdeleted")
    private int isDeleted;
}
