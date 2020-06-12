package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by zhangjie on 2020/6/12.
 */
public class IgnoreTest {

    @Test
    public void ignoreTest1(){
        System.out.println("ignorTest1");
    }
    @Test(enabled = false)
    public void ignoreTest2(){
        System.out.println("ignorTest2");
    }

    @Test
    public void ignoreTest3(){
        System.out.println("ignorTest3");
    }
}
