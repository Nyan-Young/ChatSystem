package com.upupup.service;

import com.upupup.domain.BuddyList;

public interface BuddyListService {
    String allBuddy(Integer id);
    BuddyList findOneBuddy(Integer id,Integer buddyId);
    void addBuddy(Integer id,Integer buddyId);
    String delBuddy(Integer id,Integer buddyId);
    Boolean isBuddy(Integer id,Integer buddyId);
}
