package com.autong.utilities.fileOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public class ReadWriteExcels {

    File file;
    FileInputStream fileInputStream;
    XSSFWorkbook xssfWorkbook;

    public Object readExcel(String filePath, int sheetIndex, int rowIndex, int columnIndex) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetIndex);
        return xssfSheet.getRow(rowIndex).getCell(columnIndex);
    }

    public XSSFSheet setToWriteExcel(String filePath, int sheetIndex) throws IOException {
        file = new File(filePath);
        fileInputStream = new FileInputStream(file);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        return xssfWorkbook.getSheetAt(sheetIndex);
    }

    public XSSFRow getRowFromSheet(String filePath, int sheetIndex, int rowIndex) throws IOException {
        return setToWriteExcel(filePath, sheetIndex).getRow(rowIndex);
    }
}
