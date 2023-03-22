package com.upupup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ViewController {
    //网站首页页面
    @RequestMapping(value = "index",produces = "text/html;charset=UTF-8")
    public String index(){
        return "index";
    }
    //登录页面
    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }
    //注册页面
    @RequestMapping(value = "register")
    public String register(){
        return "register";
    }
    //登录成功后的主页面
    @RequestMapping(value = "home")
    public String home(){
        return "home";
    }
    //主页面-我的
    @RequestMapping(value = "home_mine")
    public String home_mine(){
        return "home_mine";
    }
    //主页面-我的-基本信息
    @RequestMapping(value = "home_mine_basic")
    public String home_mine_basic(){
        return "home_mine_basic";
    }
    //主页面-我的-修改信息
    @RequestMapping(value = "home_mine_update")
    public String home_mine_update(){
        return "home_mine_update";
    }
    //主页面-我的-修改密码
    @RequestMapping(value = "home_mine_password")
    public String home_mine_password(){
        return "home_mine_password";
    }
    //主页面-我的-退出登录
    @RequestMapping(value = "home_mine_logout")
    public String home_mine_logout(){
        return "home_mine_logout";
    }
    //主页面-聊天
    @RequestMapping(value = "home_chat")
    public String home_chat(){
        return "home_chat";
    }
    //主页面-好友
    @RequestMapping(value = "home_buddy")
    public String home_buddy(){
        return "home_buddy";
    }
    //主页面-查找
    @RequestMapping(value = "home_search")
    public String home_search(){
        return "home_search";
    }
}
