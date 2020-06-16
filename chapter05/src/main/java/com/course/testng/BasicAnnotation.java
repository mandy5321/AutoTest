package com.course.testng;

import org.testng.annotations.*;

/**
 * Created by zhangjie on 2020/6/11.
 */
public class BasicAnnotation {

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }
    @Test
    public void test1(){
        System.out.println("这个是测试用例1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Beforeclass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }
    @BeforeSuite
    public void  beforeSuite(){
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }


    @BeforeGroups
    public void beforeGroups(){
        System.out.println("beforegroups");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("aftergroups");
    }
}
