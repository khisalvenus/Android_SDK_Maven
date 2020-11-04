package com.Android_SDK_Native;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;


public class ExcelUtil {

    public static String GetValueFromExcel(int sheetNo, int colNumber, int rowNumber) throws IOException {
        FileInputStream inputStream = new FileInputStream("/Volumes/DataDisk/Ahmadkhisal/Consoliads/Automation/Automation_Data/SDK_ValidationLogs.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        Sheet sheetMain = wb.getSheetAt(sheetNo);
        Iterator<Row> rowIterator = sheetMain.iterator(); // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getRowNum() == rowNumber) {// For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.println("column index" + cell.getColumnIndex());//You will have your columns fixed in Excel file
                    if (cell.getColumnIndex() == colNumber)//for example of c
                    {
                        System.out.println("This is the value we are looking for" + cell.getStringCellValue());
                        return cell.getStringCellValue();
                    }
                }
            }
        }
        return null;
    }

    public static void WriteToExcel(int sheetNo,int rowNumber, int cellNubmer, String value, byte red, byte green) throws IOException {
        // Create a workbook instances
        FileInputStream inputStream = new FileInputStream(new File("/Volumes/DataDisk/Ahmadkhisal/Consoliads/Automation/Automation_Data/SDK_ValidationLogs.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        // Creating a sheet using predefined class provided by Apache POI
        Sheet sheet = wb.getSheetAt(sheetNo);
        // Specific cell number
        Row row = sheet.getRow(rowNumber);
        //Create a new cell in current row
        XSSFFont font = wb.createFont();
        font.setItalic(true);
        font.setBold(true);
        byte[] rgb = {red, green, 0};
        XSSFColor finalColor = new XSSFColor(rgb, null);
        font.setColor(finalColor);
        XSSFCellStyle style = wb.createCellStyle();
        style.setFont(font);
        Cell cell = row.getCell(cellNubmer);
        cell.setCellStyle(style);
        // putting value at specific position
        cell.setCellValue(value);
        inputStream.close();
        FileOutputStream outFile = new FileOutputStream("/Volumes/DataDisk/Ahmadkhisal/Consoliads/Automation/Automation_Data/SDK_ValidationLogs.xlsx");
        wb.write(outFile);
        outFile.close();
    }
}
