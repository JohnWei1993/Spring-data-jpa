package com.bizfocus.consulservice.customer.service.impl;

import com.bizfocus.consulservice.customer.dto.CustomerDTO;
import com.bizfocus.consulservice.customer.dto.CustomerResultDTO;
import com.bizfocus.consulservice.customer.entity.Customer;
import com.bizfocus.consulservice.customer.repository.CustomerRepository;
import com.bizfocus.consulservice.customer.service.CustomerService;
import com.bizfocus.consulservice.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-06 13:30
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResultDTO getCustomerList(CustomerDTO customerDTO) {
        List<Customer> resultList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        CustomerDTO customerDTO1 = null;
        if (resultList != null && resultList.size() > 0){
            for (Customer customer : resultList){
                customerDTO1 = transferEntityToDto(customer);
                customerDTOList.add(customerDTO1);
            }
        }
        CustomerResultDTO customerResultDTO = new CustomerResultDTO();
        customerResultDTO.setCustomerDTOList(customerDTOList);
        return customerResultDTO;
    }

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = transferDtoToEntity(customerDTO);
        customerRepository.save(customer);
    }

    private Customer transferDtoToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setCode(customerDTO.getCode());
        customer.setCreateTime(new Date());
        customer.setCreateBy(1);
        customer.setUpdateTime(new Date());
        customer.setUpdateBy(1);
        customer.setIsDeleted(0);
        return customer;
    }

    private CustomerDTO transferEntityToDto(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setCode(customer.getCode());
        customerDTO.setCreateTime(DateUtils.formatDate(customer.getCreateTime(), "yyyy-MM-dd"));
        customerDTO.setCreateBy(customer.getCreateBy());
        customerDTO.setUpdateTime(DateUtils.formatDate(customer.getUpdateTime(), "yyyy-MM-dd"));
        customerDTO.setUpdateBy(customer.getUpdateBy());
        customerDTO.setIsDeleted(customer.getIsDeleted());
        return customerDTO;
    }
}
