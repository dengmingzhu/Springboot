package com.example.demo.service.impl;

import com.example.demo.entity.SysMenuEntity;
import com.example.demo.mapper.SysMenuMapper;
import com.example.demo.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author DengMingZhu
 * @Date 2019/12/23 17:44
 * @Version 1.0
 */
@Service("SysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public void saveMenu(SysMenuEntity sysMenuEntity) {
        sysMenuMapper.insert(sysMenuEntity);
    }
}
