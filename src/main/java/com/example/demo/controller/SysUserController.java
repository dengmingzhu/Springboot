package com.example.demo.controller;

import com.example.demo.entity.SysUserEntity;
import com.example.demo.from.SysLoginForm;
import com.example.demo.service.SysUserRoleService;
import com.example.demo.service.SysUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author DengMingZhu
 * @Date 2019/12/20 10:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public void login(@RequestBody SysLoginForm sysLoginForm) throws IOException {
        //用户信息
        SysUserEntity user = sysUserService.queryByUserName(sysLoginForm.getUsername());

        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(sysLoginForm.getPassword())) {
            System.out.println("账号或密码不正确");
            return;
        }
        //账号锁定
        if (user.getStatus() == 0) {
            System.out.println("账号已被锁定,请联系管理员");
            return;
        }
    }

    /**
     * 保存用户
     */
    @PostMapping("save")
    public void save(@RequestBody SysUserEntity userEntity) throws Exception {
        userEntity.setCreateuserid(userEntity.getUid());
        sysUserService.saveUser(userEntity);
        //给定一个默认角色admin
        sysUserRoleService.saveOrUpdate(userEntity.getUid(),1244L);
    }


}
