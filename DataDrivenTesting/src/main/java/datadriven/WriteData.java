package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
	
	public void writedata(int sheetname, int rownnum, int cellnum, String celldata) throws IOException {
		String filepath = "C:\\Users\\helical\\Desktop\\avi\\DataDrivenTesting\\TestData\\test-data.xlsx";
		//String sheetname ="logindata";
		
		FileInputStream fis = new FileInputStream("C:\\Users\\helical\\Desktop\\avi\\DataDrivenTesting\\TestData\\test-data-write.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		sheet.getRow(rownnum).createCell(cellnum).setCellValue(celldata);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\helical\\Desktop\\avi\\DataDrivenTesting\\TestData\\test-data-write.xlsx");
		wb.write(fos);
		fos.close();
		
		fis.close();
			
	}

}
