package datadriventests;

import java.io.IOException;

import org.testng.annotations.Test;

import datadriven.ExcelUtitlity;

public class ExcelUtitlityTest {

	@Test
	public void excelutilitytest() throws IOException {
		ExcelUtitlity el = new ExcelUtitlity();
		String us = el.readdata(0, 6, 1);
		System.out.println(us);
	}
}
