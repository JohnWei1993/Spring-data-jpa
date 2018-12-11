package com.bizfocus.consulservice.customer.dto;

import com.bizfocus.consulservice.user.dto.PageInfoDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-06 13:31
 **/
@Setter
@Getter
public class CustomerDTO extends PageInfoDTO {
    private long id;

    private String name;

    private String code;

    private String createTime;

    private long createBy;

    private String updateTime;

    private long updateBy;

    private int isDeleted;
}
