package com.example.demo.service.impl;

import com.example.demo.entity.SysRoleEntity;
import com.example.demo.entity.SysUserEntity;
import com.example.demo.mapper.SysRoleMapper;
import com.example.demo.mapper.SysUserMapper;
import com.example.demo.service.SysRoleService;
import com.example.demo.service.SysUserRoleService;
import com.example.demo.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Author DengMingZhu
 * @Date 2019/12/20 10:00
 * @Version 1.0
 */
@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;


    @Override
    public SysUserEntity queryByUserName(String username) {
        return sysUserMapper.queryByUserName(username);
    }

    @Override
    public void saveUser(SysUserEntity user) throws Exception {
        user.setCreatetime(new Date());
        user.setPassword(user.getPassword());
        sysUserMapper.insert(user);

    }

//    @Override
//    public void bindDefaultUserRole(SysRoleEntity roleEntity) {
//        sysRoleMapper.insert(roleEntity);
//    }


}
