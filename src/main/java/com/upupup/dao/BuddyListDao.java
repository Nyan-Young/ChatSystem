package com.upupup.dao;

import com.upupup.domain.BuddyList;
import com.upupup.domain.UserInfo;

import java.util.List;

public interface BuddyListDao {
    List<UserInfo> selectAllById(Integer id);
    List<UserInfo> selectAllByBuddyId(Integer buddyId);
/*    List<Integer> selectAllById(Integer id);
    List<Integer> selectAllByBuddyId(Integer buddyId);*/
    Integer selectOneById(Integer id);
    Integer selectOneByBuddyId(Integer buddyId);
    BuddyList selectBuddyList(Integer id,Integer buddyId);
    void insertBuddy(BuddyList buddyList);
    void deleteBuddy(BuddyList buddyList);
}
