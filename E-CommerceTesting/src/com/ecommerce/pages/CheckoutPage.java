package com.ecommerce.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	
	private WebDriver driver;
	private List<WebElement> updateQuantity, price, submit, removeButton;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void updateSingleItemQuantity(String quantity) throws InterruptedException{
		
		price = driver.findElements(By.className("pricedisplay"));
		System.out.println("Current price of an item: "+price.get(0).getText());
	
		updateQuantity = driver.findElements(By.name("quantity"));
		updateQuantity.clear();
		updateQuantity.get(0).sendKeys(quantity);
		submit = driver.findElements(By.name("submit"));
		submit.get(0).click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		price = driver.findElements(By.className("pricedisplay"));
		System.out.println("Updated price of an item: "+price.get(0).getText());
		
		removeButton = driver.findElements(By.name("submit"));
		removeButton.get(1).click();
		Thread.sleep(2000);
		
		if(removeButton.isEmpty())
			System.out.println("Remove item failed");
		else
			System.out.println("Remove item is successful");
		
	}
	
	public void updateMultipleItemQuantity(String quantity){
		
		WebElement checkoutTable = driver.findElement(By.className("checkout_cart"));
		List<WebElement> rows = checkoutTable.findElements(By.tagName("tr"));
		int rowSize = rows.size();

		for(int i=1; i<rowSize; i++){
			for(int j=0; j<5; j++){
				try{
					WebElement checkoutTable2 = driver.findElement(By.className("checkout_cart"));
					List<WebElement> rows2 = checkoutTable2.findElements(By.tagName("tr"));
					List<WebElement> columns = rows2.get(i).findElements(By.tagName("td"));
					WebElement qty = columns.get(2).findElement(By.name("quantity"));
					int qty1 = Integer.parseInt(quantity);
					qty1=qty1+1;
					String qty2 = Integer.toString(qty1);
					qty.clear();
					qty.sendKeys(qty2);
					qty.submit();
					break;
				}catch (StaleElementReferenceException e) {
					e.toString();
					System.out.println("Trying to recover from a stale element :" + e.getMessage());
				}
			}
			
		}
	}

}
