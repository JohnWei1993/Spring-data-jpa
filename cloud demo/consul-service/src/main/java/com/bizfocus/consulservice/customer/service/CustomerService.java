package com.bizfocus.consulservice.customer.service;

import com.bizfocus.consulservice.customer.dto.CustomerDTO;
import com.bizfocus.consulservice.customer.dto.CustomerResultDTO;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-06 13:30
 **/
public interface CustomerService {
    CustomerResultDTO getCustomerList(CustomerDTO customerDTO);

    void addCustomer(CustomerDTO customerDTO);
}
