package com.example.demo.service;

import com.example.demo.entity.SysRoleEntity;
import com.example.demo.entity.SysUserEntity;

/**
 * @Author DengMingZhu
 * @Date 2019/12/20 9:49
 * @Version 1.0
 */
public interface SysUserService {

    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);

    /**
     * 保存用户
     */
    void saveUser(SysUserEntity user) throws Exception;

    /**
     * 绑定用户默认角色信息
     */
//    void bindDefaultUserRole(SysRoleEntity roleEntity);

}
