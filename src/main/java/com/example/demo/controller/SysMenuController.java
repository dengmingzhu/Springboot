package com.example.demo.controller;

import com.example.demo.entity.SysMenuEntity;
import com.example.demo.service.SysMenuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统菜单
 * @Author DengMingZhu
 * @Date 2019/12/23 17:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Resource
    private SysMenuService sysMenuService;

    @PostMapping("/save")
    public void save(@RequestBody SysMenuEntity menu) throws Exception{

        //TODO

        sysMenuService.saveMenu(menu);

    }

}
