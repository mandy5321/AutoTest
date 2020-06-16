package com.course.httpclient.demo;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by zhangjie on 2020/6/12.
 */
public class httpClientDemo {
    @Test
    public void test1() throws IOException {
        //用来存储结果
        String result;
        HttpGet  get = new HttpGet("http://www.baidu.com");
        //用来执行get方法
        HttpClient client=new DefaultHttpClient();
        client.execute(get);

    }
}
