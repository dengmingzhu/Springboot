package com.example.demo.service;

import com.example.demo.entity.SysRoleEntity;

import java.util.List;

/**
 * @Author DengMingZhu
 * @Date 2019/12/20 15:09
 * @Version 1.0
 */
public interface SysRoleService {

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);

    void saveRole(SysRoleEntity sysRoleEntity);
}
