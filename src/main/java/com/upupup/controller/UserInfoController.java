package com.upupup.controller;

import com.upupup.domain.UserInfo;
import com.upupup.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    //根据id查询用户信息&反馈用户信息&用于登录后查找功能&好友添加情况
    @RequestMapping(value = "info",method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String info(Integer id,Integer buddyId){
        return userInfoService.findUserInfoById(id,buddyId);
    }
    //根据id更新用户数据
    @RequestMapping(value = "updateInfo",method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String updateInfo(Integer id, @RequestParam(required = false) Boolean gender, @RequestParam(required = false) String birthdate){
        return userInfoService.changeUserInfo(id,gender,birthdate);
    }
    //根据信息注册新用户&反馈是否注册成功
    @RequestMapping(value = "register0",method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String register0(String userName, String password, Boolean gender, String birthdate){
        UserInfo userInfo=new UserInfo(null,userName,password,gender,birthdate);
        return userInfoService.addUserInfo(userInfo);
    }
    //登录&反馈是否登录成功
    @RequestMapping(value = "login0", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String login0(String userName, String password){
        UserInfo userInfo=new UserInfo(null,userName,password,null,null);
        return userInfoService.findUserInfoByUser(userInfo);
    }
    @RequestMapping(value = "details", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String details(Integer buddyId){
        return userInfoService.findUserInfoById(null,buddyId);
    }
    @RequestMapping(value = "resetPassword", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String resetPassword(Integer id,String p_old,String password){
        return userInfoService.changePassword(id,p_old,password);
    }
}
