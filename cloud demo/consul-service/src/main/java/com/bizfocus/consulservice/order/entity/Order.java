package com.bizfocus.consulservice.order.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-07 14:51
 **/
@Table(name = "order")
@Entity
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customerId")
    private long customerId;

    @Column(name = "orderdate")
    private Date orderDate;

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
