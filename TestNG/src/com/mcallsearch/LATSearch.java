package com.mcallsearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LATSearch {
	
	private WebDriver driver;
	private String URL = "http://www.mcall.com/";

	@BeforeTest
	public void OpenSite() {
		System.setProperty("webdriver.chrome.driver", "D:\\Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}

	@Parameters("searchTerm")
	@Test
	public void LATSearchTest(String searchKey) {
		driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/a")).click();
		driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/form/div/input[1]")).sendKeys(searchKey);
		driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/form/div/input[4]")).click();
		assert "Brad Pitt".equals(searchKey);		
	}
}
