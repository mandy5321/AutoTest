package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by zhangjie on 2020/6/13.
 */
public class MyClientForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
        //System.out.println(url);
    }
    @Test
    public void  testGetCookies() throws IOException {
        String result;
        String uri=bundle.getString("getCookies.uri");
        //System.out.println(uri);
        String testUrl =this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        //HttpClient client = new DefaultHttpClient();
        DefaultHttpClient client = new DefaultHttpClient();
        //获取返回信息
        HttpResponse response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取返回cookies

        this.store=client.getCookieStore();
        List<Cookie> cookielist= store.getCookies();
        for (Cookie cookie:cookielist) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name+":"+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookie() throws IOException {
        String result;
        String uri = bundle.getString("test.get.with.cookie");
        String testurl = this.url + uri;
        System.out.println(testurl);

        HttpGet get= new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookie
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if(statusCode==200){
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }
}
