package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilsExcel {

    public static Workbook workbook;
    public static Sheet sheet;
    static String sheetPath = System.getProperty("user.dir")+"/src/main/resources/TestData.xlsx";
    public static Object[][] getTestDataFromExcel(String sheet_Name){

        FileInputStream file = null;

        try {
            file = new FileInputStream(sheetPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheet(sheet_Name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int totalrows = sheet.getLastRowNum();
        System.out.println(totalrows);
        int totalCol = sheet.getRow(0).getLastCellNum();
        System.out.println(totalCol);

        Object data[][] = new Object[totalrows][totalCol];

        for(int r =0; r<sheet.getLastRowNum(); r++){
            for(int c=0; c<sheet.getRow(0).getLastCellNum(); c++){
                data[r][c] = sheet.getRow(r+1).getCell(c).toString();
            }
        }

return data;
    }

    @DataProvider
    public Object[][] getData(){
        return getTestDataFromExcel("Sheet1");
    }
}
