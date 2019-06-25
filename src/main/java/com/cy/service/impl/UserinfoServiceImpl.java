package com.cy.service.impl;

import com.cy.dao.UserinfoMapper;
import com.cy.entity.Userinfo;
import com.cy.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    private Userinfo userinfo;

    @Override
    public int insert(Userinfo userinfo) {

        System.out.println(userinfo+"service层调用dao层方法");
        return userinfoMapper.insertSelective(userinfo);
    }

    @Override
    public ArrayList<Userinfo> selectUser(Userinfo userinfo) {
        return null;
    }

    /**
     *
     * @param userName
     * @param password
     * @return
     *  检查登录信息 核对密码
     *
     */
    @Override
    public Userinfo checkLogin(String userName,String password) {

        userinfo = userinfoMapper.selectByUserName(userName);
        if (userinfo != null && userinfo.getPassword().equals(password)){
            return userinfo;
        }
        return null;
    }

    @Override
    public Userinfo selectByUserName(String userName) {
        System.out.println("service："+userName);
        userinfo = userinfoMapper.selectByUserName(userName);
        if (userinfo != null){
            return userinfo;
        }
        return null;
    }
}
