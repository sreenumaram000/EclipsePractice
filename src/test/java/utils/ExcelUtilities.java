package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	 public static Object[][] getExcelData(String sheetName) throws IOException {
	        FileInputStream fis = new FileInputStream("src/test/resources/testData/" + sheetName + ".xlsx");
	        XSSFWorkbook wb = new XSSFWorkbook(fis);
	        XSSFSheet sheet = wb.getSheetAt(1);

	        int rowCount = sheet.getPhysicalNumberOfRows() - 1; // exclude header
	        int colCount = sheet.getRow(0).getLastCellNum();

	        Object[][] data = new Object[rowCount][colCount];
	        
	        for(int i=1; i<=rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for(int j=0; j<colCount; j++) {
	                Cell cell = row.getCell(j);
	                data[i-1][j] = cell.toString();
	            }
	        }
	        wb.close();
	        return data;
	    }

}
