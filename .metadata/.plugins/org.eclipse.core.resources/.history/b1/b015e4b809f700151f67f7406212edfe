package com.ecommerce.pageObjects;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PageObjects {
	
	WebDriver driver;
	
	public PageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addToCart() throws InterruptedException{
		
		WebElement goToCheckoutButton, continueShoppingButton;
		List<WebElement> addToCartButton = driver.findElements(By.className("wpsc_buy_button"));
		
		System.out.println("Number of 'Add To Cart' buttons are: "+addToCartButton.size());
		addToCartButton.get(0).click();
		Thread.sleep(2000);
	}
	
	public void navigationToPages(String subMenuName){
		
		System.out.println("Page to be navigated to: "+subMenuName);
		WebElement topMenuName = driver.findElement(By.xpath("html/body/div[2]/div/div/header/nav/ul/li[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(topMenuName).build().perform();
		driver.findElement(By.linkText(subMenuName)).click();
		
		String pageHeader = driver.findElement(By.className("page-header")).getText();
		System.out.println("Page navigated to is: "+pageHeader);
	
		Assert.assertEquals(pageHeader, subMenuName, "Navigation is successful");
		
		if(pageHeader.equals(subMenuName))
			System.out.println("Navigation to page "+subMenuName+" is successful");
		else
			System.out.println("Navigation to page "+subMenuName+" failed");
	}
}
