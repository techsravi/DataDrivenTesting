package datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtitlity {
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	String filepath;
	String sheetname;

	public ExcelUtitlity() throws IOException {
		filepath = "C:\\Users\\helical\\Desktop\\avi\\DataDrivenTesting\\TestData\\test-data.xlsx";
		fis = new FileInputStream(filepath);
		wb = new XSSFWorkbook(fis);
	}
	public String readdata(int sheetindex, int rownum, int cellnum) {
		sheet = wb.getSheetAt(sheetindex);
		String logindata = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
		return logindata;
	}
}
