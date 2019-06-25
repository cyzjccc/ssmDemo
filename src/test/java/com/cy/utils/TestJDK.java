package com.cy.utils;

import com.cy.entity.TbUser;

public class TestJDK {
    public static void  main(String args[]){
        TbUser u = new TbUser();
        u.setId(1);
        u.setUserName("lyf");
        u.setName("刘亦菲");
        u.setSex("女");
        u.setAge(18);
        System.out.println(u);
    }
}
