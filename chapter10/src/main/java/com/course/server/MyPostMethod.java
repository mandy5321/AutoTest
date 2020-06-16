package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.course.bean.User;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangjie on 2020/6/15.
 */
@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("v1")
public class MyPostMethod {
    private  static Cookie cookie;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，登录成功后返回cookies",httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestParam(value = "userName",required = true) String username,@RequestParam(value = "passWord",required = true) String password){
        if(username.equals("zhangsan") && password.equals("123456")){
            cookie =new Cookie("login","success");
            response.addCookie(cookie);
            return "恭喜登录成功";
        }
        return "用户名或密码错误";
    }
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User u){
        Cookie[] cookies=request.getCookies();
        User user;
        for(Cookie c:cookies){
            if(c.getName().equals("login") && c.getValue().equals("success") && u.getUsername().equals("zhangsan") &&u.getPassword().equals("12345")){
                user = new User();
                user.setName("lisi");
                return user.toString();

            }
        }
        return "获取用户列表失败";

    }

}
