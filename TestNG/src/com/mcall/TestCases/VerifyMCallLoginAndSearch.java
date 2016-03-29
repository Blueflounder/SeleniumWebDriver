package com.mcall.TestCases;

import org.testng.annotations.*;
import org.testng.AssertJUnit;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.mcall.pages.*;

@Listeners({com.bitwise.listeners.Listeners.class})
public class VerifyMCallLoginAndSearch {

	private WebDriver driver;
	private InboxPage inbox;
	private LoginPage login;
	private Search search;
	private String appURL = "http://www.mcall.com/";
	private String hubURL = "http://10.10.125.70:4444/wd/hub"; 
	private DesiredCapabilities cap;
	
		
	@BeforeMethod
	public void testSetup() throws MalformedURLException {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
		login = new LoginPage(driver);
		
		//For RemoteWebDriver
		/*cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setVersion("41.0.2");
		cap.setPlatform(Platform.WINDOWS);
		
		driver = new RemoteWebDriver(new java.net.URL("http://10.10.125.70:4444/wd/hub"), cap);
		driver.manage().window().maximize();
		driver.get(appURL);
		login = new LoginPage(driver);*/
		
		
	}
	
	//Calling 'Forgot Password' functionality
	/*@Test(groups = {"login"})
	public void verifyForgotPwd() throws InterruptedException {
		
	String msg = login.verifyForgotPwd("tribuneqa.device@gmail.com");
	Assert.assertEquals(msg, "Your password has been sent", "Reset Password link sent successfully");

	}*/
		
	@Test(groups = {"login"})
	public void loginWithValidUser() throws InterruptedException {

		inbox = login.loginWithValidUser("tribuneqa.device@gmail.com", "abcd1234");
		boolean usern = inbox.getLoggedInUserName();
		Assert.assertEquals(usern, "true", "User is logged in successfully");
		
	}
	
	/*@Test(groups = {"login"})
	public void loginWithInValidEmail() throws InterruptedException {

		String error = login.loginWithInValidEmail("tribuneqa.device@gmail.co.in", "abcd1234");

		Assert.assertEquals(error,
				"This user does not exist. Please enter a valid email address.", "Check error message for  invalid email ID");

	}
	
	@Test(groups = {"login"})
	public void loginWithInValidPwd() throws InterruptedException {

		String error = login.loginWithInValidPwd("tribuneqa.device@gmail.com", "s@vuyi244");

		Assert.assertEquals(error, "Please enter a valid password.", "Check error message for invalid password");

	}
	
	@Test (groups = {"search"})
	public void MCallSearch(){
		
		search.MCallSearchTest("Brad Pitt");
	}

	@AfterMethod
	public void testTeardown() {

		String msg = search.MCallSearchTest("Brad Pitt");
		

	}*/
/*	@AfterMethod
	public void teardown(){
		
		driver.quit();
	}
*/
}
