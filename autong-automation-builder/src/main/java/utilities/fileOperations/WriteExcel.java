package utilities.fileOperations;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public abstract class WriteExcel {

    File file;
    FileInputStream fileInputStream;
    XSSFWorkbook xssfWorkbook;

    public XSSFSheet setToWriteExcel(String filePath, int sheetIndex) throws IOException {
        file = new File(filePath);
        fileInputStream = new FileInputStream(file);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        return xssfWorkbook.getSheetAt(sheetIndex);
    }

    public XSSFRow getRowFromSheet(String filePath, int sheetIndex, int rowIndex) throws IOException {
        return setToWriteExcel(filePath, sheetIndex).getRow(rowIndex);
    }

    public abstract void writeExcel() throws IOException;
}
