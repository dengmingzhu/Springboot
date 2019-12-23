package com.example.demo.controller;
import com.example.demo.Util.ExcelUtil;
import com.example.demo.entity.TCity;
import com.example.demo.service.CtiyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author DengMingZhu
 * @Date 2019/12/16 15:00
 * @Version 1.0
 */
@RestController
public class CityController {

    @Resource
    private CtiyService ctiyService;

    @RequestMapping("/inster")
    public TCity addCity(TCity tCity) throws Exception {
        List<List<String>> listob = null;
        try {
            listob = new ExcelUtil().POItest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < listob.size(); i++) {
            List<String> lo = listob.get(i);
            TCity city = new TCity();
            city.setId(Integer.valueOf(lo.get(0)));
            city.setAreaId(String.valueOf(lo.get(1)));
            city.setProvince(lo.get(2));
            city.setCity(lo.get(3));
            city.setDistrict(String.valueOf(lo.get(4)));
            ctiyService.inster(city);
        }
        return tCity;
    }
}
