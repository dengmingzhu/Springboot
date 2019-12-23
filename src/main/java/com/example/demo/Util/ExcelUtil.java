package com.example.demo.Util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author DengMingZhu
 * @Date 2019/12/12 20:01
 * @Version 1.0
 */
public class ExcelUtil {

    public List<List<String>> POItest() throws Exception {
        HttpServletRequest request = null;
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("abc");
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(file.getName()));
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream("D:\\解析Test.xls"));
        boolean is2007 = true;
        if (file.getName().endsWith("xlsx")) {
            is2007 = false;
        }
        InputStream input = new FileInputStream(file.getName());  //建立输入流
        Workbook wb = null;
        //根据文件格式(2003或者2007)来初始化
        if (is2007)
            wb = new HSSFWorkbook(input);
        else
            wb = new XSSFWorkbook(input);
        Sheet sheet = wb.getSheetAt(0);
        if (sheet == null) {
            System.out.println("工作表为空");
            throw new Exception("错误：工作表为空");
        }
        int allRowNum = sheet.getLastRowNum();
        Row row = sheet.getRow(0);
        int allCellNum = row.getLastCellNum();
        System.out.println("共有" + allRowNum + "行" + allCellNum + "列");

        List<List<String>> alllist = new ArrayList<List<String>>();
        for (int i = 1; i <= allRowNum; i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            List<String> list = new ArrayList<>();
            for (int j = row.getFirstCellNum(); j < allCellNum; j++) {
                //首先强制设置成string类型
                row.getCell(j).setCellType(XSSFCell.CELL_TYPE_STRING);
                //再读取
                String cell = row.getCell(j).getStringCellValue();//当是数字时候调用该方法读值会出错
                System.out.println("当前单元格：" + cell);
                if (cell == null) {
                    continue;
                }
                list.add(cell);
            }
            alllist.add(list);
        }
        return alllist;
    }
}


