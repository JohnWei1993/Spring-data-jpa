package com.bizfocus.consulservice.customer.repository;

import com.bizfocus.consulservice.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-06 13:31
 **/
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
