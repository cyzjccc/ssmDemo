package com.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller标识一个Spring类是Spring MVC controller处理器,
// 也就是加了@Controller，这个文件就会被spring认为是处理请求的
@Controller
public class TbUserController {
    @RequestMapping("login/go")
    public String getShow() {

        return "show";
    }

    //@PathVariable可以将 URL 中占位符参数绑定到控制器处理方法的入参中:
// URL 中的 {xxx} 占位符可以通过，@PathVariable("xxx") 绑定到操作方法的入参中。
    @RequestMapping(value = "login/info/data={userName}")
    public String getInfo(@PathVariable("userName") String name, Model model) {
        model.addAttribute("data", name);
        return "info";
    }

    @RequestMapping(value = "login/getMessagePost", method = RequestMethod.POST)
    public String getMessagePost(@RequestParam("userName") String username, @RequestParam("password") String password, Model model) {
        model.addAttribute("nameData", username);
        model.addAttribute("passwordData", password);
//        model.addAttribute("formType", "get");
        return "message";
    }

    @RequestMapping(value = "login/getMessageGet", method = RequestMethod.GET)
    public String getMessageGet(@RequestParam("userName") String username, @RequestParam("password") String password, Model model) {
        model.addAttribute("nameData", username);
        model.addAttribute("passwordData", password);
//        model.addAttribute("formType", "post");
        return "message";
    }
}
