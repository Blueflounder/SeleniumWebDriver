package com.test.OnlineStore;

import org.openqa.selenium.WebDriver;

import com.test.PageObjecttClass.PageObject;

public  class HomePageObject extends PageObject {

	public HomePageObject(WebDriver driver) {
		super(driver);
		
	}

	HomePageObject home;

	public void clickonNavigationMenu(String page) throws InterruptedException {

		navigateToPage(page);
		

	}
	
	public void checkMoreInfoForItem(){
		
		
	}
	
	public void scrollItem(){
		
	}

}
