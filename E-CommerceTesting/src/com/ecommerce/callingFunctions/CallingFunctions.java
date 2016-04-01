package com.ecommerce.callingFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.ecommerce.pageObjects.PageObjects;
import com.ecommerce.pages.AccessoriesPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.iPhonesPage;

public class CallingFunctions {
	
	AccessoriesPage acc;
	PageObjects obj;
	CheckoutPage cp;
	HomePage home;
	iPhonesPage iPhone;
	private WebDriver driver;
	private String URL = "http://store.demoqa.com/";
	
	@BeforeMethod
	public void OpenSite() throws InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		acc = new AccessoriesPage(driver);
		cp = new CheckoutPage(driver);
		home = new HomePage(driver);
		iPhone = new iPhonesPage(driver);
	}
	
	@Test(enabled=true)
	public void verifyThatAllItemsAreAddedToCart() throws InterruptedException{
		
		iPhone.navigationToPages("iPhones");
		acc.addMultipleItemsToCart();
		cp.updateMultipleItemQuantity("1");
	}
	
	@Test(enabled=false)
	public void verifyThatItemsIsAddedToCart() throws InterruptedException{
		
		home.navigationToPages("Accessories");
		acc.addSingleItemToCart(0);
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}
	
	

}