package com.bizfocus.consulservice.user.service;

import com.bizfocus.consulservice.user.dto.UserDTO;
import com.bizfocus.consulservice.user.dto.UserResultDTO;

import java.util.List;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-11-30 16:00
 **/
public interface UserService {
    UserResultDTO getUserList(UserDTO userDTO);

    void addUser(UserDTO userDTO);

    UserResultDTO getUserListByName(UserDTO userDTO);

    UserResultDTO getUserByCriteria(UserDTO userDTO);
}
