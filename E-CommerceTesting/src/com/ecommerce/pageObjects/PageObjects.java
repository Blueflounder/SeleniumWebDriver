package com.ecommerce.pageObjects;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public abstract class PageObjects {

	WebDriver driver;
	private WebElement goToCheckoutButton, continueShoppingButton;
	private List<WebElement> addToCartButton;

	public PageObjects(WebDriver driver) {
		this.driver = driver;
	}
	

	public void addSingleItemToCart(int i) throws InterruptedException {

		addToCartButton = driver.findElements(By.className("wpsc_buy_button"));
		addToCartButton.get(i).click();

		String continuePopUp = driver.getWindowHandle();
		driver.switchTo().window(continuePopUp);
//		System.out.println("Current window is: "+continuePopUp);

		Thread.sleep(2000);
		goToCheckoutButton = driver.findElement(By.className("go_to_checkout"));
		goToCheckoutButton.click();
	}

	public void addMultipleItemsToCart() throws InterruptedException {
		
		addToCartButton = driver.findElements(By.className("wpsc_buy_button"));
		System.out.println("Number of 'Add To Cart' buttons are: " + addToCartButton.size());

		for (int i = 0; i < addToCartButton.size(); i++) {
			Thread.sleep(2000);
			addToCartButton.get(i).click();

			String continuePopUp = driver.getWindowHandle();
			driver.switchTo().window(continuePopUp);

			if (i != addToCartButton.size() - 1) {
				Thread.sleep(3000);
				continueShoppingButton = driver.findElement(By.className("continue_shopping"));
				continueShoppingButton.click();
				System.out.println("And the shopping goes on!!!");
			} else {
				Thread.sleep(2000);
				goToCheckoutButton = driver.findElement(By.className("go_to_checkout"));
				goToCheckoutButton.click();
				System.out.println("Poof!!! Finally checking out!!!");
				Thread.sleep(500);
			}
		}
	}

	public void navigationToPages(String subMenuName) {

		System.out.println("Page to be navigated to: " + subMenuName);
		WebElement topMenuName = driver.findElement(By.xpath("html/body/div[2]/div/div/header/nav/ul/li[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(topMenuName).build().perform();
		driver.findElement(By.linkText(subMenuName)).click();

		String pageHeader = driver.findElement(By.className("page-header")).getText();
		System.out.println("Page navigated to is: " + pageHeader);

		Assert.assertEquals(pageHeader, subMenuName, "Navigation is successful");

		if (pageHeader.equals(subMenuName))
			System.out.println("Navigation to page " + subMenuName + " is successful");
		else
			System.out.println("Navigation to page " + subMenuName + " failed");
	}
}
