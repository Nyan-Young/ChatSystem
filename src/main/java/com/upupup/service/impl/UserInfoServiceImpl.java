package com.upupup.service.impl;

import com.upupup.dao.UserInfoDao;
import com.upupup.domain.BuddyList;
import com.upupup.domain.UserInfo;
import com.upupup.service.BuddyApplyService;
import com.upupup.service.BuddyListService;
import com.upupup.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Resource
    private BuddyListService buddyListService;
    @Resource
    private BuddyApplyService buddyApplyService;
    //注册新用户
    @Override
    public String addUserInfo(UserInfo userInfo) {
        String res="";
        if(userInfoDao.selectOneByUser(userInfo.getUserName())==null){
            userInfoDao.insertUserInfo(userInfo);
            res="注册成功";
        }else{
            res="用户名已存在";
        }
        return res;
    }

    //登录验证
    @Override
    public String findUserInfoByUser(UserInfo userInfo) {
        UserInfo userInfo0=userInfoDao.selectOneByUser(userInfo.getUserName());
        String res="";
        if(userInfo0==null){
            res="用户名不存在";
        }else if(!userInfo0.getPassword().equals(userInfo.getPassword())){
            res="密码错误";
        }else{
            res=userInfo0.toString()+"+"+buddyListService.allBuddy(userInfo0.getId());
        }
        return res;
    }

    //根据id查找用户信息&好友添加情况
    @Override
    public String findUserInfoById(Integer id,Integer buddyId) {
        UserInfo userInfo=userInfoDao.selectOne(buddyId);
        String res="";
        if(id==null){
            return userInfo.toString();
        }
        if(userInfo!=null){
            res=userInfo.toString()+"+"+buddyApplyService.findApply(id,buddyId);
        }else{
            res="用户ID不存在";
        }
        return res;
    }

    //更新用户性别，生日
    @Override
    public String changeUserInfo(Integer id, Boolean gender, String birthdate) {
        UserInfo userInfo=new UserInfo(id,null,null,gender,birthdate);
        if(gender!=null){
            userInfoDao.updateUserGender(userInfo);
        }
        else{
            userInfoDao.updateUserBirthdate(userInfo);
        }
        return userInfo.toString();
    }
    @Override
    public String changePassword(Integer id,String p_old,String password){
        UserInfo userInfo=new UserInfo(id,p_old,password,null,null);
        int res=userInfoDao.updatePassword(userInfo);
        if(res==0){
            return "密码输入不正确！";
        }else{
            return "success";
        }
    }
}
