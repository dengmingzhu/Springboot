package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Author DengMingZhu
 * @Date 2019/10/31 15:51
 * @Version 1.0
 */
@RestController
public class HelloController {

    //    返回cookie信息get接口
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(HttpServletResponse response) {
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "getCookes。。。";
    }

    //    客户端携带cookie访问
    @RequestMapping(value = "get/cookie",method=RequestMethod.GET)
    public String getWithCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "必须携带cookie才能访问";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")) {
                return "访问成功";
            }
        }
        return "cookie访问";
    }

}
