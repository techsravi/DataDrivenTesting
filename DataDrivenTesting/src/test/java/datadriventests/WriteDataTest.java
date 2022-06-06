package datadriventests;

import java.io.IOException;

import org.testng.annotations.Test;

import datadriven.WriteData;

public class WriteDataTest {

	@Test
	public void writedatatest() throws IOException {
		WriteData wd=new WriteData();
		wd.writedata(0, 0, 2, "Status");
	}
}
