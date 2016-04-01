package com.test.OnlineStore;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPageObject {
	
	private WebDriver driver;
	
	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean updateQtyOfAllItemsByNo(String quantity) {

		WebElement element = driver.findElement(By.name("quantity"));
		element.clear();
		element.sendKeys(quantity);
		element.submit();
		List<WebElement> prices = driver.findElements(By.className("pricedisplay"));
		System.out.println("Price :" + prices.get(0).getText());

		// getting the price of the items from table:
		String total = prices.get(0).getText();
		String price = prices.get(1).getText();
		int qty = Integer.parseInt(quantity);

		// stripping the price and total of '$' and converting to integer
		int intTotal = ShoppingCartUtilities.StripAndConvertToInt(total);
		int intPrice = ShoppingCartUtilities.StripAndConvertToInt(price);
		System.out.println("int price:" + intPrice);
		System.out.println("int price:" + intTotal);
		System.out.println(qty * intPrice);
		// checking if total = price * qty
		if ((qty * intPrice) == intTotal)
			return true;
		else
			return false;
	}
	
	public void removeAllElementsFromCart() throws InterruptedException {
		WebElement shoppingCartTable = driver.findElement(By.className("checkout_cart"));
		List<WebElement> rows = shoppingCartTable.findElements(By.tagName("tr"));
		int items = rows.size();
		for (int i = 1; i < items; items--) {
			System.out.println("Size of rownum " + items);

			// Iteration to check the element is returned
			for (int j = 0; j < 5; j++)
				try {
					System.out.println("Trying to locate the element: " + j);
					WebElement shoppingCartTable1 = driver.findElement(By.className("checkout_cart"));
					List<WebElement> rows1 = shoppingCartTable1.findElements(By.tagName("tr"));
					List<WebElement> cols = rows1.get(i).findElements(By.tagName("td"));
					// clicking on 'Remove' button
					cols.get(5).findElement(By.name("submit")).click();
					break;
				} catch (StaleElementReferenceException e) {
					e.toString();
					System.out.println("Trying to recover from a stale element :" + e.getMessage());
				}

			Thread.sleep(3000);
		}

	}
	public void ContinueToPurchase() throws InterruptedException
	{
		driver.findElement(By.className("step2")).click();
		WebElement country=driver.findElement(By.id("current_country"));
		Thread.sleep(4000);
		Select se=new Select(country);
		se.selectByVisibleText("Greece");
		driver.findElement(By.name("wpsc_submit_zipcode")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(("div[class='review group']")));
		WebElement table=driver.findElement(By.cssSelector(("table[class='wpsc_checkout_table table-4']")));
		List<WebElement> row=table.findElements(By.tagName("tr"));
		System.out.println("tr"+row.size());
		List<WebElement> col=row.get(1).findElements(By.tagName("td"));
		String price=col.get(1).findElement(By.className("pricedisplay")).getText();
		int intTax=ShoppingCartUtilities.StripAndConvertToInt(price);
		System.out.println("price"+intTax);
		Thread.sleep(2000);
		//return intTax;
	}
}
