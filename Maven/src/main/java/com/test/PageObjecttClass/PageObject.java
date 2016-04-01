package com.test.PageObjecttClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class PageObject {
	
	protected WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
	}

	protected void addToCart() throws InterruptedException {

		WebElement continueBtn = null;
		WebElement checkoutBtn;

		List<WebElement> addCartbtn = driver.findElements(By.className("wpsc_buy_button"));
		System.out.println("No of Items: " + addCartbtn.size());
		for (int i = 0; i < addCartbtn.size(); i++) {
			Thread.sleep(2000);
			System.out.println("for loop size" + i);
			addCartbtn.get(i).click();
			String continuePopUp = driver.getWindowHandle();
			driver.switchTo().window(continuePopUp);
			// driver.findElement(By.className("continue_shopping")).click();
			if (i != addCartbtn.size() - 1) {
				System.out.println("Loop");
				Thread.sleep(3000);
				continueBtn = driver.findElement(By.className("continue_shopping"));
				continueBtn.click();
				System.out.println("Continue Shopping !");
			} else {
				Thread.sleep(2000);
				checkoutBtn = driver.findElement(By.className("go_to_checkout"));
				// WebDriverWait wait = new WebDriverWait(driver, 10);
				checkoutBtn.click();
				System.out.println("Checking out !");
				Thread.sleep(500);
			}
		}
	}

	protected void navigateToPage(String page) {
		
		System.out.println("Navigation");
		WebElement element = driver.findElement(By.linkText("Product Category"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText(page)).click();

	}

}
