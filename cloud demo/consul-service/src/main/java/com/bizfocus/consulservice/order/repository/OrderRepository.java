package com.bizfocus.consulservice.order.repository;

import com.bizfocus.consulservice.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-12-10 09:42
 **/
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
