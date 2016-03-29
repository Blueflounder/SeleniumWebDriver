package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxPage {
	
	WebDriver driver;
	
	By userNameLabel = By.xpath("//*[@id='gb']/div[1]/div[1]/div[1]/div/span");
	
	public InboxPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoggedInUserName() throws InterruptedException{
		
		 String userName = driver.findElement(userNameLabel).getText();
		 return userName;
	}
	
	public void logout(){
		
		driver.findElement(By.xpath("//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
		driver.findElement(By.id("gb_71")).click();
	}
}
