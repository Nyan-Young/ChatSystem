package com.upupup.dao;

import com.upupup.domain.BuddyApply;
import com.upupup.domain.UserInfo;

import java.util.List;

public interface BuddyApplyDao {
    void insertApply(BuddyApply buddyApply);
    BuddyApply selectApply(BuddyApply buddyApply);
    List<UserInfo> selectAllId(Integer applyId);
    List<UserInfo> selectAllApply(Integer id);
    void deleteApply(BuddyApply buddyApply);
}
