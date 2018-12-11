package com.bizfocus.consulservice.user.controller;

import com.bizfocus.consulservice.config.ResponseData;
import com.bizfocus.consulservice.user.dto.UserDTO;
import com.bizfocus.consulservice.user.dto.UserResultDTO;
import com.bizfocus.consulservice.user.service.UserService;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-11-30 15:53
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    public ResponseData<UserResultDTO> getUserList(@RequestBody UserDTO userDTO) throws Exception{
        ResponseData<UserResultDTO> rd = new ResponseData<UserResultDTO>();
        try{
            UserResultDTO userResultDTO = userService.getUserList(userDTO);

            rd.setData(userResultDTO);
            rd.setResult(true);
            rd.setMessage("请求成功！");
        }catch (Exception e){
            rd.setResult(false);
            rd.setMessage("请求失败！");
            throw new Exception(e);
        }

        return rd;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseData<String> addUser(@RequestBody UserDTO userDTO) throws Exception{
        ResponseData<String> rd = new ResponseData<>();
        try {
            userService.addUser(userDTO);
            rd.setResult(true);
            rd.setMessage("保存成功");
        }catch (Exception e){
            throw new Exception(e);
        }
        return rd;
    }

    @RequestMapping(value = "/getUserByName", method = RequestMethod.POST)
    public ResponseData<UserResultDTO> getUserListByName(@RequestBody UserDTO userDTO) throws Exception{
        ResponseData<UserResultDTO> rd = new ResponseData<>();
        try{
            UserResultDTO userResultDTO = userService.getUserListByName(userDTO);
            rd.setResult(true);
            rd.setData(userResultDTO);
            rd.setMessage("请求成功");
        }catch (Exception e){
            rd.setResult(false);
            rd.setMessage("请求失败！");
            throw new Exception(e);
        }
        return rd;
    }

    @RequestMapping(value = "/getUserByCriteria", method = RequestMethod.POST)
    public ResponseData<UserResultDTO> getUserByCriteria(@RequestBody UserDTO userDTO) throws Exception{
        ResponseData<UserResultDTO> rd = new ResponseData<>();
        try{
            UserResultDTO userResultDTO = userService.getUserByCriteria(userDTO);
            rd.setResult(true);
            rd.setData(userResultDTO);
            rd.setMessage("请求成功");
        }catch (Exception e){
            rd.setResult(false);
            rd.setMessage("请求失败！");
            throw new Exception(e);
        }
        return rd;
    }
}
