package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import excelutility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public static Properties p;
	public static FileReader reader;
	
	@BeforeMethod
	public static void base() throws IOException {
		
		reader=new FileReader("C:\\Users\\helical\\Desktop\\avi\\DataDrivenTesting\\PropertyFiles\\config.properties");
		p=new Properties();  
		p.load(reader);  
		
		System.out.println(p.getProperty("browser"));  
		    
		if(p.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(p.getProperty("url"));
		}
		else if(p.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(p.getProperty("url"));

		}
		else
		{
			System.out.println("browser not found");
		}
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	@DataProvider(name="logindata")
	public Object[][] data() {
		Object[][] testdata = new Object[4][2];
		
		testdata[0][0] = "Admin";
		testdata[0][1] = "admin123";
		testdata[1][0] = "Admin";
		testdata[1][1] = "admin123#";
		testdata[2][0] = "Admin";
		testdata[2][1] = "admin123";
		testdata[3][0] = "Admin";
		testdata[3][1] = "admin^123";
		
		return testdata;
	}
	
	@DataProvider(name="orangehrmlogindata")
	public Object[][] orangehrmdata() {
		ExcelUtility exlutility=new ExcelUtility("C:\\Users\\helical\\Desktop\\avi\\DataDrivenTesting\\TestData\\test-data-orange-hrm.xlsx");
		int rowcount = exlutility.getRowCount("logindata");
		//System.out.println(rowcount);
		int actrows = rowcount-1;
		int colcount = exlutility.getColumnCount("logindata");
		//System.out.println(colcount);
		Object[][] obj = new Object[actrows][colcount];
		for(int i = 0;i<actrows;i++) {
			for(int j=0;j<colcount;j++) {
				
				obj[i][j] = exlutility.getCellData("logindata", j, i+2);
			}
		}
		
		
		
		return obj;
	}
	
	
}
