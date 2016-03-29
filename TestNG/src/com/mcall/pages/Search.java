package com.mcall.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Search {

	private WebDriver driver;
	
	@Parameters({"searchTerm"})
	@Test
	public Boolean MCallSearchTest(String searchKey) {
		
		driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/a")).click();
		driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/form/div/input[1]")).sendKeys(searchKey);
		driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/form/div/input[4]")).click();
			
		Boolean successMsg = driver.findElement(By.xpath("html/body/div[2]/div[4]/span/span")).isDisplayed();
		return successMsg;
	}
}
