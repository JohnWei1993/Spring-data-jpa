package com.bizfocus.consulservice.customer.controller;

import com.bizfocus.consulservice.config.ResponseData;
import com.bizfocus.consulservice.customer.dto.CustomerDTO;
import com.bizfocus.consulservice.customer.dto.CustomerResultDTO;
import com.bizfocus.consulservice.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-06 13:29
 **/
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    public ResponseData<CustomerResultDTO> getUserList(@RequestBody CustomerDTO customerDTO) throws Exception{
        ResponseData<CustomerResultDTO> rd = new ResponseData<CustomerResultDTO>();
        try{
            CustomerResultDTO customerResultDTO = customerService.getCustomerList(customerDTO);

            rd.setData(customerResultDTO);
            rd.setResult(true);
            rd.setMessage("请求成功！");
        }catch (Exception e){
            rd.setResult(false);
            rd.setMessage("请求失败！");
            throw new Exception(e);
        }

        return rd;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ResponseData<String> addCustomer(@RequestBody CustomerDTO customerDTO) throws Exception{
        ResponseData<String> rd = new ResponseData<>();
        try {
            customerService.addCustomer(customerDTO);
            rd.setResult(true);
            rd.setMessage("保存成功");
        }catch (Exception e){
            throw new Exception(e);
        }
        return rd;
    }
}
