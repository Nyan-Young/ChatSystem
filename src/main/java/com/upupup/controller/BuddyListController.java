package com.upupup.controller;

import com.upupup.service.BuddyListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class BuddyListController {
    @Resource
    private BuddyListService buddyListService;
    @RequestMapping(value = "buddyList", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String buddyList(Integer id){
        return buddyListService.allBuddy(id);
    }
    @RequestMapping(value = "buddyDelete", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String buddyDelete(Integer id,Integer buddyId){
        return buddyListService.delBuddy(id,buddyId);
    }
}
