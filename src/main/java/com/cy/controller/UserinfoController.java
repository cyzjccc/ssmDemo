package com.cy.controller;

import com.cy.entity.Userinfo;
import com.cy.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserinfoController {


    @Autowired
    private UserinfoService userinfoService;

    private Userinfo userinfo;

    @RequestMapping(value="/login/login", method = RequestMethod.GET)
    public String login() {
        System.out.println("*********进入登录页面*********");
        return "login";
    }

    /**
     *
     * @param session
     * @param model
     * @param user
     * @return 登录
     */
    @RequestMapping(value = "/login/login", method = RequestMethod.POST)
    public String reachLogin(HttpSession session, Model model, @ModelAttribute Userinfo user) {
        userinfo = userinfoService.selectByUserName(user.getName());
        System.out.println(user.getName()+"........................");
        if (userinfo == null){
            //判断是否有该用户
            model.addAttribute("status",1);
        }else {
            //判断用户名、密码是否一致
            userinfo = userinfoService.checkLogin(user.getName(),user.getPassword());
            if (userinfo == null ){
                model.addAttribute("status",2);
            }else {
                model.addAttribute("status",0);
            }
            session.setAttribute("userinfo",userinfo);
        }
        return "login";
    }
    @RequestMapping("login/toLogin")
    public String getLogin() {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return "login";
    }
    @RequestMapping("login/info")
    public String getShow() {

        return "show";
    }

    @RequestMapping(value="/user/userInfo", method = RequestMethod.GET)
    public String userInfoMessage(Model model, HttpSession session) {
        userinfo = (Userinfo) session.getAttribute("userinfo");
        if(userinfo != null){
            model.addAttribute("user", userinfo);
        }
        return "userInfo";
    }
    @RequestMapping(value = "/user/register",method = RequestMethod.GET)
    public String userInfoRegisterGet(){
        System.out.println("*********进入注册页面*********");
        return "register";
    }
    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public String userInfoRegister(@ModelAttribute Userinfo user ,Model model){
        userinfo = userinfoService.selectByUserName(user.getName());
        System.out.println("**************"+user+"**************");
        if (userinfo == null){
            Userinfo userInfoInsert = new Userinfo();
            userInfoInsert.setName(user.getName());
            userInfoInsert.setPassword(user.getPassword());
            userInfoInsert.setDate(new Date());
            userInfoInsert.setUpdatetime(new Date());
            userInfoInsert.setCode("1");
            System.out.println("即将注册的用户："+userInfoInsert);
            if (userinfoService.insert(userInfoInsert) == 1){
                model.addAttribute("status",0);
            }else {
                model.addAttribute("status",1);
            }
        }else{
            model.addAttribute("status",2);
            System.out.println("已存在用户："+user.getName());
        }

        return "register";
    }

    @RequestMapping(value="/user/logout")
    public String userInfoLogOut(HttpSession session) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        session.invalidate();
        return "login";
    }
}
