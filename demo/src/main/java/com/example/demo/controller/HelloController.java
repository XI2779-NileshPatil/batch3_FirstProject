package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.ResponseObject;

@RestController
public class HelloController {
	
	@GetMapping
	public String hello() {
		return "Hello";
	}
	
	
//	@GetMapping("/hello/{name}")
//	public Employee greet(@PathVariable("name") String name) {
//		System.out.println("Hello "+name);
//		return new Employee(1,name,2000);
//		
//	}
	
	@CrossOrigin
	@GetMapping("/getFile")
	public ResponseObject createSheet() throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");
         
        Object[][] bookData = {
                {"Head First Java", "Kathy Serria", 79},
                {"Effective Java", "Joshua Bloch", 36},
                {"Clean Code", "Robert martin", 42},
                {"Thinking in Java", "Bruce Eckel", 35},
        };
 
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = 0;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
             
        }
         
         
//        try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx")) {
//            workbook.write(outputStream);
//        }
        
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        workbook.write(os);
        //return ;
        Map<String, byte[]> map = new HashMap<String, byte[]>();
        map.put("excelfile.xlsx", os.toByteArray());
        
        return new ResponseObject(map);
	}

}
