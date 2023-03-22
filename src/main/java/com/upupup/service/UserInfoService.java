package com.upupup.service;

import com.upupup.domain.UserInfo;

public interface UserInfoService {
    String addUserInfo(UserInfo userInfo);
    String findUserInfoById(Integer id,Integer buddyId);
    String findUserInfoByUser(UserInfo userInfo);
    String changeUserInfo(Integer id, Boolean gender, String birthdate);
    String changePassword(Integer id,String p_old,String password);
}
