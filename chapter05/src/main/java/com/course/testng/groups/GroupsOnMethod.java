package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * Created by zhangjie on 2020/6/12.
 */
public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端的test1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端的test2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端的test3");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端之前运行的方法");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端之后运行的方法");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnclient(){
        System.out.println("这是客户端之前运行的方法");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("这是客户端之后运行的方法");
    }

}
