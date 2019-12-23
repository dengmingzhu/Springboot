package com.example.demo.service.impl;

import com.example.demo.entity.SysRoleEntity;
import com.example.demo.mapper.SysRoleMapper;
import com.example.demo.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author DengMingZhu
 * @Date 2019/12/20 15:12
 * @Version 1.0
 */
@Service("SysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<Long> queryRoleIdList(Long createUserId) {

        return sysRoleMapper.queryRoleIdList(createUserId);
    }

    @Override
    public void saveRole(SysRoleEntity roleEntity) {
        roleEntity.setCreatetime(new Date());
        sysRoleMapper.insert(roleEntity);
    }
}
