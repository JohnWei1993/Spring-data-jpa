package com.bizfocus.consulservice.customer.dto;

import com.bizfocus.consulservice.user.dto.PageInfoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-06 13:31
 **/
@Setter
@Getter
public class CustomerResultDTO extends PageInfoDTO {
    private List<CustomerDTO> customerDTOList;
}
