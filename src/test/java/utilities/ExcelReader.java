package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	FileInputStream fis;
	XSSFWorkbook workbook;
	public void getExcelData() throws IOException {
		fis = new FileInputStream("D:\\Rathna\\Hackathons\\Team2_APIDiet_RestAssured\\Team2_APIDiet_Data.xlsx");
		workbook = new XSSFWorkbook(fis);
		
	}
}
