package base;

import org.testng.annotations.Test;

import excelutility.ExcelUtility;

public class testexcel {

	@Test
	public Object[][] testt() {
		ExcelUtility exlutility=new ExcelUtility("C:\\Users\\helical\\Desktop\\avi\\DataDrivenTesting\\TestData\\test-data-orange-hrm.xlsx");
		int rowcount = exlutility.getRowCount("logindata");
		System.out.println(rowcount);
		int colcount = exlutility.getColumnCount("logindata");
		System.out.println(colcount);
		Object[][] obj = new Object[rowcount][colcount];
		for(int i = 1;i<rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				
				obj[i][j] = exlutility.getCellData("logindata", j, i);
			}
		}
		
		
		
		return obj;
		
	}
}
