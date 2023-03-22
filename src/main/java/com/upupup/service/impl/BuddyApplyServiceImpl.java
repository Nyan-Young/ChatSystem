package com.upupup.service.impl;

import com.upupup.dao.BuddyApplyDao;
import com.upupup.domain.BuddyApply;
import com.upupup.domain.UserInfo;
import com.upupup.service.BuddyApplyService;
import com.upupup.service.BuddyListService;
import com.upupup.utils.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuddyApplyServiceImpl implements BuddyApplyService {
    @Resource
    BuddyApplyDao buddyApplyDao;
    @Resource
    BuddyListService buddyListService;
    //发送好友申请
    @Override
    public String addApply(Integer id, Integer buddyId) {
        BuddyApply buddyApply=new BuddyApply(id,buddyId);
        buddyApplyDao.insertApply(buddyApply);
        return "success";
    }
    //查找是否已给指定id的用户发送过申请&是否接收过来自该用户的申请
    @Override
    public String findApply(Integer id, Integer buddyId) {
        BuddyApply buddyApply1=new BuddyApply(id,buddyId);
        BuddyApply buddyApply2=new BuddyApply(buddyId,id);
        String res="";
        if(buddyApplyDao.selectApply(buddyApply1)!=null){
            res="等待对方添加";
        }else if(buddyApplyDao.selectApply(buddyApply2)!=null){
            res="同意添加好友";
        }else{
            res="加好友";
        }
        return res;
    }
    //查找所有好友申请
    @Override
    public List<List<String>> findAllApply(Integer id) {
        List<List<String>> apply=new ArrayList<>();
        apply.add(Utils.toStandardUser(buddyApplyDao.selectAllId(id)));
        apply.add(Utils.toStandardUser(buddyApplyDao.selectAllApply(id)));
        return apply;
    }
    //同意好友申请
    @Override
    public String agreeApply(Integer id, Integer buddyId) {
        BuddyApply buddyApply=new BuddyApply(id,buddyId);
        buddyApplyDao.deleteApply(buddyApply);
        buddyListService.addBuddy(id,buddyId);
        return "success";
    }

    @Override
    public String deleteApply(Integer id, Integer buddyId) {
        BuddyApply buddyApply=new BuddyApply(id,buddyId);
        buddyApplyDao.deleteApply(buddyApply);
        return "success";
    }
}
