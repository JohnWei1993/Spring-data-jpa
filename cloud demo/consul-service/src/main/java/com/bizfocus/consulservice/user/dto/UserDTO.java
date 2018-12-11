package com.bizfocus.consulservice.user.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-11-30 16:30
 **/
@Getter
@Setter
public class UserDTO extends PageInfoDTO{
    private long id;

    private String name;

    private int age;

    private String createTime;

    private long createBy;

    private String updateTime;

    private long updateBy;

    private int isDeleted;

}
