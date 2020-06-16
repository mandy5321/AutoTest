package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by zhangjie on 2020/6/14.
 */
public class MyCookieForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }
    @Test
    public void getCookie() throws IOException {
        String uri = bundle.getString("getCookies.uri");
        String testurl = this.url+uri;
        System.out.println(testurl);
        DefaultHttpClient client =new DefaultHttpClient();
        HttpGet get = new HttpGet(testurl);
        HttpResponse response = client.execute(get);

        this.store = client.getCookieStore();
    }

    @Test(dependsOnMethods = "getCookie")
    public void testCookieForPost() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String testUrl = this.url+uri;
        System.out.println(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(testUrl);

        //参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        //头部
        post.setHeader("content-type","application/json");
        //入参
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        client.setCookieStore(this.store);

        HttpResponse response = client.execute(post);

        String result = EntityUtils.toString(response.getEntity());

        System.out.println(result);
        JSONObject resultJson=new JSONObject(result);
        String status = (String) resultJson.get("status");
        String laile = (String) resultJson.get("huhansan");
        //（预期结果，实际结果）
        Assert.assertEquals("1",status);
        Assert.assertEquals("laile",laile);

    }
}
