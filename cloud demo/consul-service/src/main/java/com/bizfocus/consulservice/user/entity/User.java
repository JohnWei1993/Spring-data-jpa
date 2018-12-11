package com.bizfocus.consulservice.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-11-30 15:55
 **/

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

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
