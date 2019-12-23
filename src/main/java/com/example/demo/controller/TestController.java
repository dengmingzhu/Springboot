package com.example.demo.controller;

import com.example.demo.entity.Team;
import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static jdk.nashorn.tools.Shell.SUCCESS;

/**
 * @Author DengMingZhu
 * @Date 2019/12/9 21:46
 * @Version 1.0
 */
@RestController
public class TestController {

    @RequestMapping("test")
    private String test(@RequestBody Team team) {
        System.out.println(team.toString());
        return team.toString();
    }

    @RequestMapping("test1")
    private String test1(@RequestBody User user,@RequestParam("token") List<String> token) {
        System.out.println(user.toString());
        StringBuffer stringBuffer=new StringBuffer();
        for(String str:token){
            stringBuffer.append(str);
            System.out.println(str);
        }
        return token+"--------------"+user.toString();
    }

    @RequestMapping("test2")
    private String test2(@RequestBody User user,String users) {
        System.out.println(user.toString());
        return user.toString()+"=================="+users;
    }

}
