package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.service.CtiyService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author DengMingZhu
 * @Date 2019/12/12 20:01
 * @Version 1.0
 */
@RestController
//@RequestMapping("test")
public class POIController {

    @Autowired
    private CtiyService ctiyService;

    @Test
    public void POItest() throws Exception {
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        MultipartFile file = multipartRequest.getFile("abc");
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(file.getName()));
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream("D:\\解析Test.xls"));
        //TODO 后缀名xlsx AND xls判定

        HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
        if (sheet == null) {
            System.out.println("工作表为空");
            throw new Exception("错误：工作表为空");
        }
        int allRowNum = sheet.getLastRowNum();
        Row row = sheet.getRow(0);
        int allCellNum = row.getLastCellNum();
        System.out.println("共有" + allRowNum + "行" + allCellNum + "列");

        List<List<String>> alllist=new ArrayList<List<String>>();
        for (int i = 1; i <= allRowNum; i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            List<String> list=new ArrayList<>();
            for (int j = row.getFirstCellNum(); j < allCellNum; j++) {
                //首先强制设置成string类型
                row.getCell(j).setCellType(XSSFCell.CELL_TYPE_STRING);
                //再读取
                String cell = row.getCell(j).getStringCellValue();
                System.out.println("当前单元格：" + cell);//当是数字时候调用该方法读值会出错
                if (cell == null) {
                    continue;
                }
            }
            alllist.add(list);
        }
        for (int i=0;i<alllist.size();i++){
            List<String> lo = alllist.get(i);
            System.out.println("集合数据为"+lo);
            City city=new City();
            city.setId(Integer.valueOf(lo.get(0)));
            city.setName(String.valueOf(lo.get(1)));
            city.setCountrycode(lo.get(2));
            city.setDistrict(lo.get(3));
            city.setPopulation(Integer.valueOf(lo.get(4)));
            ctiyService.inster(city);
        }
    }


}