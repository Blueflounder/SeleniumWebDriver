package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TransactionResultsPage {

	WebDriver driver;
	
	public TransactionResultsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void getPageHeader(){
		String pageHeader = driver.findElement(By.className("entry-title")).getText();
		Assert.assertEquals(pageHeader, "Transaction Results", "Purchase is successful");
	}
}
