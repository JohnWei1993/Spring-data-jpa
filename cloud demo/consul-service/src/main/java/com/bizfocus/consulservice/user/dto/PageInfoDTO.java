package com.bizfocus.consulservice.user.dto;

import lombok.Data;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-04 15:24
 **/
@Data
public class PageInfoDTO {
    private int page;
    private int pageSize;
    private int totalSize;
    private int totalPage;
    private String sort;
}
