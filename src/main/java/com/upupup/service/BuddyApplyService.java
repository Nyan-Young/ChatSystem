package com.upupup.service;

import java.util.List;

public interface BuddyApplyService {
    String addApply(Integer id,Integer buddyId);
    String findApply(Integer id,Integer buddyId);
    List<List<String>> findAllApply(Integer id);
    String agreeApply(Integer id,Integer buddyId);
    String deleteApply(Integer id,Integer buddyId);
}
