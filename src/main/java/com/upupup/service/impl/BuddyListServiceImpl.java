package com.upupup.service.impl;

import com.upupup.dao.BuddyListDao;
import com.upupup.domain.BuddyList;
import com.upupup.domain.UserInfo;
import com.upupup.service.BuddyApplyService;
import com.upupup.service.BuddyListService;
import com.upupup.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BuddyListServiceImpl implements BuddyListService {
    @Resource
    private BuddyListDao buddyListDao;
    @Resource
    private BuddyApplyService buddyApplyService;

    @Override
    public String allBuddy(Integer id) {
        List<UserInfo> list=buddyListDao.selectAllById(id);
        list.addAll(buddyListDao.selectAllByBuddyId(id));
        return StringUtils.join(Utils.toStandardUser(list),",");
    }
/*
    @Override
    public List<Integer> allBuddy(Integer id) {
        List<Integer> list=buddyListDao.selectAllById(id);
        list.addAll(buddyListDao.selectAllByBuddyId(id));
        return list;
    }*/

    @Override
    public BuddyList findOneBuddy(Integer id, Integer buddyId) {
        return null;
    }

    @Override
    public void addBuddy(Integer id, Integer buddyId) {
        buddyApplyService.deleteApply(buddyId,id);
        if(id>buddyId){
            int temp=buddyId;
            buddyId=id;
            id=temp;
        }
        BuddyList buddyList=new BuddyList(id,buddyId);
        File file=new File(Utils.dir+id+"_"+buddyId+ Utils.doc);
        if(!file.exists()){
            try {
                file.createNewFile();
                Utils.write1st(file);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        buddyListDao.insertBuddy(buddyList);
    }

    @Override
    public String delBuddy(Integer id,Integer buddyId){
        if(id>buddyId){
            int temp=buddyId;
            buddyId=id;
            id=temp;
        }
        BuddyList buddyList=new BuddyList(id,buddyId);
        buddyListDao.deleteBuddy(buddyList);
        return "success";
    }
    @Override
    public Boolean isBuddy(Integer id, Integer buddyId) {
        return null;
    }
}
