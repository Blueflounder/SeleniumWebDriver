package com.bitwise.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstJavaProgram {
	
	public static void main(String args[]) throws InterruptedException 
	{
		
	System.setProperty("webdriver.chrome.driver", "D:\\Browser Drivers\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.get("http://bitwisestaging.azurewebsites.net/");
	
	driver.findElement(By.id("s")).sendKeys("Test Automation");
	driver.findElement(By.id("searchFromheader")).click();
	driver.findElement(By.xpath("/html/body/footer/div[2]/div/div[3]/ul/li[1]/ul/li[1]/a")).click();
	
	driver.quit();
		
    }
	

}
