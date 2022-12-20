package utilities.fileOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author shwetankvashishtha
 */
public class ReadExcel {

    public Object readExcel(String filePath, int sheetIndex, int rowIndex, int columnIndex) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetIndex);
        return xssfSheet.getRow(rowIndex).getCell(columnIndex);
    }
}
