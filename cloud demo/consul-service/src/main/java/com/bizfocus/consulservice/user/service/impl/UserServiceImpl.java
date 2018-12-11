package com.bizfocus.consulservice.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizfocus.consulservice.user.dto.UserDTO;
import com.bizfocus.consulservice.user.dto.UserResultDTO;
import com.bizfocus.consulservice.user.entity.User;
import com.bizfocus.consulservice.user.repository.UserRepository;
import com.bizfocus.consulservice.user.service.UserService;
import com.bizfocus.consulservice.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-11-30 16:00
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResultDTO getUserList(UserDTO userDTO) {
        UserResultDTO userResultDTO = new UserResultDTO();
        Page<User> pageResult = userRepository.findAll(PageRequest.of(userDTO.getPage(), userDTO.getPageSize(), Sort.by(Sort.Direction.ASC, userDTO.getSort())));
        System.out.println(JSON.toJSONString(pageResult));
        List<User> userList = pageResult.getContent();
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO result = null;
        if (userList != null && userList.size() > 0){
            for (User user : userList){
                result = transferUserToUserDTO(user);
                userDTOList.add(result);
            }
        }
        userResultDTO.setUserDTOList(userDTOList);
        userResultDTO.setPage(userDTO.getPage());
        userResultDTO.setPageSize(userDTO.getPageSize());
        userResultDTO.setSort(userDTO.getSort());
        userResultDTO.setTotalPage(pageResult.getTotalPages());
        userResultDTO.setTotalSize((int) pageResult.getTotalElements());

        return userResultDTO;
    }

    @Override
    public void addUser(UserDTO userDTO) {
        User user = transferUserDTOToUser(userDTO);
        userRepository.save(user);
    }

    @Override
    public UserResultDTO getUserListByName(UserDTO userDTO) {
        UserResultDTO userResultDTO = new UserResultDTO();
        Page<User> pageResult = userRepository.getUserListByName(userDTO.getName(),
                PageRequest.of(userDTO.getPage(), userDTO.getPageSize(), Sort.by(Sort.Direction.ASC, userDTO.getSort())));
        List<User> userList = pageResult.getContent();
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO result = null;
        if (userList != null && userList.size() > 0){
            for (User user : userList){
                result = transferUserToUserDTO(user);
                userDTOList.add(result);
            }
        }
        userResultDTO.setUserDTOList(userDTOList);
        userResultDTO.setPage(userDTO.getPage());
        userResultDTO.setPageSize(userDTO.getPageSize());
        userResultDTO.setSort(userDTO.getSort());
        userResultDTO.setTotalPage(pageResult.getTotalPages());
        userResultDTO.setTotalSize(pageResult.getContent().size());
        return userResultDTO;
    }

    @Override
    public UserResultDTO getUserByCriteria(UserDTO userDTO) {
        UserResultDTO userResultDTO = new UserResultDTO();
        Page<User> pageResult = userRepository.getUserListByNameAndAge(userDTO.getName(), userDTO.getAge(),
                PageRequest.of(userDTO.getPage(), userDTO.getPageSize(), Sort.by(Sort.Direction.ASC, userDTO.getSort())));
        List<User> userList = pageResult.getContent();
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO result = null;
        if (userList != null && userList.size() > 0){
            for (User user : userList){
                result = transferUserToUserDTO(user);
                userDTOList.add(result);
            }
        }
        userResultDTO.setUserDTOList(userDTOList);
        userResultDTO.setPage(userDTO.getPage());
        userResultDTO.setPageSize(userDTO.getPageSize());
        userResultDTO.setSort(userDTO.getSort());
        userResultDTO.setTotalPage(pageResult.getTotalPages());
        userResultDTO.setTotalSize(pageResult.getContent().size());
        return userResultDTO;
    }

    private User transferUserDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        user.setCreateTime(new Date());
        user.setCreateBy(1);
        user.setUpdateTime(new Date());
        user.setUpdateBy(1);
        user.setIsDeleted(0);
        return user;
    }

    private UserDTO transferUserToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAge(user.getAge());
        userDTO.setCreateBy(user.getCreateBy());
        userDTO.setCreateTime(DateUtils.formatDate(user.getCreateTime(), "yyyy-MM-dd"));
        userDTO.setUpdateBy(user.getUpdateBy());
        userDTO.setUpdateTime(DateUtils.formatDate(user.getUpdateTime(), "yyyy-MM-dd"));
        userDTO.setIsDeleted(user.getIsDeleted());
        return userDTO;
    }
}
