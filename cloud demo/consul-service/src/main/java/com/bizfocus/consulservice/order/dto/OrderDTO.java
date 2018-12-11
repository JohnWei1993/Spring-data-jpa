package com.bizfocus.consulservice.order.dto;

import com.bizfocus.consulservice.user.dto.PageInfoDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-07 14:54
 **/
@Setter
@Getter
public class OrderDTO extends PageInfoDTO {
    private long id;

    private long customerId;

    private String orderDate;

    private String createTime;

    private long createBy;

    private String updateTime;

    private long updateBy;

    private int isDeleted;
}
