package com.test.maven.Maven;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.OnlineStore.AccesoriesPageObject;
import com.test.OnlineStore.CheckoutPageObject;
import com.test.OnlineStore.HomePageObject;

import com.test.OnlineStore.ShoppingCartUtilities;


/**
 * Hello world!
 *
 */
public class App {
	Properties p;
	WebDriver driver;
	HomePageObject home;
	String url;
	AccesoriesPageObject accs;
	CheckoutPageObject chek;
	@BeforeMethod
	public void set() throws IOException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		home = new HomePageObject(driver);
		
		p = ShoppingCartUtilities.GetObject();
		driver.get(p.getProperty("url"));// Read from object repository
		accs = new AccesoriesPageObject(driver);
		chek=new CheckoutPageObject(driver);
	}

	@Test
	public void test() throws InterruptedException {
		home.clickonNavigationMenu("iPods");
		accs.addAccessoriesItemsToCart();
		chek.updateQtyOfAllItemsByNo("2");
		Assert.assertTrue(true);
		//chek.removeall();
		//chek.removeAllElementsFromCart();
		chek.ContinueToPurchase();
	}

	@AfterMethod
	public void tear() {
		driver.quit();
	}
}
