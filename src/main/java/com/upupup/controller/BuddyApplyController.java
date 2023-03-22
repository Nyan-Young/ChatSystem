package com.upupup.controller;

import com.upupup.service.BuddyApplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BuddyApplyController {
    @Resource
    BuddyApplyService buddyApplyService;
    //发送好友申请
    @RequestMapping(value = "sendApply",method = RequestMethod.POST)
    @ResponseBody
    public String buddyApply(Integer id,Integer buddyId){
        System.out.println(buddyId);
        return buddyApplyService.addApply(id,buddyId);
    }
    //检查好友申请
    @RequestMapping(value = "checkApply",method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String checkApply(Integer id,Integer buddyId){
        return buddyApplyService.findApply(id,buddyId);
    }
    //接收好友申请
    @RequestMapping(value = "allApply",method = RequestMethod.POST)
    @ResponseBody
    public List<List<String>> allApply(Integer id){
        return buddyApplyService.findAllApply(id);
    }
    //同意好友申请
    @RequestMapping(value = "agreeApply",method = RequestMethod.POST)
    @ResponseBody
    public String agreeApply(Integer id,Integer buddyId){
        return buddyApplyService.agreeApply(id,buddyId);
    }
    //同意好友申请
    @RequestMapping(value = "deleteApply",method = RequestMethod.POST)
    @ResponseBody
    public String delApply(Integer id,Integer buddyId){
        return buddyApplyService.deleteApply(id,buddyId);
    }
}
