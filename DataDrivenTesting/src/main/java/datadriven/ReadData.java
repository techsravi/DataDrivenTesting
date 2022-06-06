package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadData {

	@Test
	void readdata() throws IOException {
		String filepath = "C:\\Users\\helical\\Desktop\\avi\\DataDrivenTesting\\TestData\\test-data.xlsx";
		String sheetname ="logindata";
		
		FileInputStream fis = new FileInputStream("C:\\Users\\helical\\Desktop\\avi\\DataDrivenTesting\\TestData\\test-data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		int colcount = sheet.getRow(0).getLastCellNum();
		System.out.println(colcount);
		//read particular cell data
		String uname = sheet.getRow(5).getCell(1).getStringCellValue();
		System.out.println(uname);
		//read data through loop
		for(int i=0;i<rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				String data= sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}
}
