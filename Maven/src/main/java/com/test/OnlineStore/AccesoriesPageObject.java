package com.test.OnlineStore;

import org.openqa.selenium.WebDriver;

import com.test.PageObjecttClass.PageObject;

public  class AccesoriesPageObject extends PageObject{

	public AccesoriesPageObject(WebDriver driver) {
		super(driver);
	
	}
	
	public CheckoutPageObject addAccessoriesItemsToCart() throws InterruptedException
	{
		addToCart();
		return new CheckoutPageObject(driver);
	}
	
	
}
