package com.mcall.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InboxPage {

	WebDriver driver;
	Actions action;

	By userNameLabel = By.xpath("//*[@id='gb']/div[1]/div[1]/div[1]/div/span");

	public InboxPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean getLoggedInUserName() throws InterruptedException {
		try {
			action = new Actions(driver);
			WebElement welcomeLink = driver.findElement(By.xpath("html/body/header/div[1]/div[1]/a[4]"));
			System.out.println(welcomeLink.isDisplayed());
			action.moveToElement(welcomeLink).build().perform();
			Thread.sleep(10);
			boolean signInStatus = welcomeLink.isDisplayed();

			return signInStatus;
		} finally {
			driver.quit();
		}
	}

	public void logout() {

		/*
		 * WebElement element =
		 * driver.findElement(By.xpath("html/body/header/div[1]/div[1]/a[4]"));
		 * 
		 * action.moveToElement(element).build().perform();
		 * driver.findElement(By.xpath(
		 * "html/body/header/div[1]/div[1]/ul/li[3]/a")).click();
		 */

	}
}
