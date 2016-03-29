package com.actionclass.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestActionClass {
	
	private WebDriver driver;
	
	public TestActionClass(){
	
	System.setProperty("webdriver.chrome.driver", "D:\\BrowserDrivers\\chromedriver.exe");
		
	driver = new ChromeDriver();
	driver.get("file:///C:/hovermenu/hovermenusample.html");
	}
	
}
