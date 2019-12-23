package com.example.demo.controller;

import com.example.demo.entity.SysRoleEntity;
import com.example.demo.service.SysRoleMenuService;
import com.example.demo.service.SysRoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author DengMingZhu
 * @Date 2019/12/23 9:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/Role")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 保存角色
     */
    @PostMapping("save")
    public void save(@RequestBody SysRoleEntity roleEntity) {
        roleEntity.setCreateuserid(roleEntity.getRoleid());
        sysRoleService.saveRole(roleEntity);
        //不是超级管理员，则需要判断角色的权限是否超过自己的权限,1244是管理员id
        if (roleEntity.getRoleid() == 1244) {
            return;
        }
        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(roleEntity.getRoleid(), 1L);
    }

}
