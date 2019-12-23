package com.example.demo.service.impl;
import com.example.demo.entity.TCity;
import com.example.demo.mapper.TCityMapper;
import com.example.demo.service.CtiyService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @Author DengMingZhu
 * @Date 2019/12/13 10:58
 * @Version 1.0
 */
@Service("ctiyService")
public class CtiyServiceImpl implements CtiyService {

    @Resource
    private TCityMapper tCityMapper;

    @Override
    public void inster(TCity tCity) {
        tCityMapper.insert(tCity);
    }
}
