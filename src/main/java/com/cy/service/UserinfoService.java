package com.cy.service;

import com.cy.entity.Userinfo;

import java.util.ArrayList;


public interface UserinfoService {

    int insert(Userinfo userinfo);

    ArrayList<Userinfo> selectUser(Userinfo userinfo);

    Userinfo checkLogin(String userName,String password);

    Userinfo selectByUserName(String userName);

}
