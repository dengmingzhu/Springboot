package com.example.demo.service.impl;

import com.example.demo.entity.SysRoleMenuEntity;
import com.example.demo.mapper.SysRoleMenuMapper;
import com.example.demo.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author DengMingZhu
 * @Date 2019/12/23 17:28
 * @Version 1.0
 */
@Service("SysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public void saveOrUpdate(Long roleId, Long menuId) {
        SysRoleMenuEntity sysRoleMenuEntity=new SysRoleMenuEntity();
        sysRoleMenuEntity.getRoleid(roleId);
        sysRoleMenuEntity.setMenuid(menuId);
        sysRoleMenuMapper.insert(sysRoleMenuEntity);
    }
}
