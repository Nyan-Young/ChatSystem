package com.upupup.dao;

import com.upupup.domain.UserInfo;

public interface UserInfoDao {
    void insertUserInfo(UserInfo userInfo);
    UserInfo selectOne(Integer id);
    UserInfo selectOneByUser(String userName);
    void updateUserInfo(UserInfo userInfo);
    void updateUserGender(UserInfo userInfo);
    void updateUserBirthdate(UserInfo userInfo);
    int updatePassword(UserInfo userInfo);
}
