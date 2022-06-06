package datadriven;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

public class LoginTestusingExcelUtitlity extends Base{

	
	@Test(dataProvider="orangehrmlogindata")
	public void datadriventest(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		String expurl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String acturl = driver.getCurrentUrl(); 
		Assert.assertEquals(acturl, expurl);
	}
}
