package com.example.demo.service.impl;

import com.example.demo.entity.SysUserRoleEntity;
import com.example.demo.mapper.SysUserRoleMapper;
import com.example.demo.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author DengMingZhu
 * @Date 2019/12/20 10:47
 * @Version 1.0
 */
@Service("SysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public void saveOrUpdate(Long userId, Long roleId) {
        //先删除用户与角色关系
//        sysUserRoleMapper.deleteByuserid(userId);
        //保存用户和角色关系
        SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
        sysUserRoleEntity.setUserid(userId);
        sysUserRoleEntity.setRoleid(roleId);
        sysUserRoleMapper.insert(sysUserRoleEntity);
    }
}
