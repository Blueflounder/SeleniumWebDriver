package com.ecommerce.callingFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.ecommerce.pageObjects.PageObjects;
import com.ecommerce.pages.AccessoriesPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.iPhonesPage;
import com.ecommerce.pages.TransactionResultsPage;

public class CallingFunctions {
	
	AccessoriesPage acc;
	PageObjects obj;
	CheckoutPage cp;
	HomePage home;
	iPhonesPage iPhone;
	TransactionResultsPage trp;
	private WebDriver driver;
	private String URL = "http://store.demoqa.com/";
	
	@BeforeTest
	public void OpenSite() throws InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		acc = new AccessoriesPage(driver);
		cp = new CheckoutPage(driver);
		home = new HomePage(driver);
		iPhone = new iPhonesPage(driver);
		trp = new TransactionResultsPage(driver);
	}
	
	@Test(enabled=false)
	public void verifyThatAllItemsAreAddedToCart() throws InterruptedException{
		
		iPhone.navigationToPages("MacBooks");
		acc.addMultipleItemsToCart();
		cp.updateMultipleItemQuantity("1");
	}
	
	@Test(enabled=true)
	public void verifyThatAnItemIsAddedToCart() throws InterruptedException{
		
		home.navigationToPages("Accessories");
		acc.addSingleItemToCart(0);
	}
	
//	@Test(dependsOnMethods = {"verifyThatAllItemsAreAddedToCart"})
//	public void removeItemsFromCart() throws InterruptedException{
//		
//		cp.removeItemsFromCart();
//	}
	
	@Test(dependsOnMethods = {"verifyThatAnItemIsAddedToCart"})
	public void verifyUserCanPurchaseItems() throws InterruptedException{
		
		cp.purchaseItems();
		Thread.sleep(2000);
		trp.getPageHeader();
	}
	
	@AfterTest
	public void tear() {
		driver.quit();
	}
	
	

}
