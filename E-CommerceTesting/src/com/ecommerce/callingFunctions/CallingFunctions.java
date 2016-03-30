package com.ecommerce.callingFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.ecommerce.pageObjects.PageObjects;

public class CallingFunctions {
	
	PageObjects obj;
	private WebDriver driver;
	private String URL = "http://store.demoqa.com/";
	
	@BeforeMethod
	public void OpenSite() {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@Test
	public void Test() throws InterruptedException{
		
		obj = new PageObjects(driver);
		obj.navigationToPages("Accessories");
		obj.addToCart();
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}
	
	

}
