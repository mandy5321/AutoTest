package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by zhangjie on 2020/6/12.
 */
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    public  void afterSuite(){
        System.out.println("AferSuite");
    }
}
