package com.actionclass.test;

import org.testng.annotations.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverMenuTest {
	
	private WebDriver driver;
	Actions action;
	
	@BeforeTest
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "D:\\BrowserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/hovermenu/hovermenusample.html");
		action = new Actions(driver);
	}

	@Test
	public void Navigation() {

		WebElement element1 = driver.findElement(By.id("home"));
		//action.moveToElement(element1).build().perform();
		
		WebElement element2 = driver.findElement(By.id("about"));
		//action.moveToElement(element2).build().perform();
		
		WebElement element3 = driver.findElement(By.id("services"));
		//action.moveToElement(element3).build().perform();
		
		List<WebElement> menuList = driver.findElements(By.tagName("li"));
		System.out.println("Available menu items are: "+menuList.size());
		
		/*action.moveToElement(menuList.get(3)).build().perform();
		action.moveToElement(menuList.get(4)).build().perform();
		action.moveToElement(menuList.get(5)).build().perform();*/
		action.moveToElement(element1).moveToElement(element2).moveToElement(element3).moveToElement(menuList.get(3)).moveToElement(menuList.get(4)).moveToElement(menuList.get(5)).build().perform();
		menuList.get(5).click();
		/*WebElement element4 = driver.findElement(By.id("About"));
		action.moveToElement(element4).build().perform();*/
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
