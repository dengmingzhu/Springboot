package com.example.demo.service.impl;

import com.example.demo.entity.City;
import com.example.demo.mapper.CityMapper;
import com.example.demo.service.CtiyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author DengMingZhu
 * @Date 2019/12/13 10:58
 * @Version 1.0
 */
@Service
public class CtiyServiceImpl implements CtiyService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public void inster(City city) {
        cityMapper.insert(city);
    }
}
