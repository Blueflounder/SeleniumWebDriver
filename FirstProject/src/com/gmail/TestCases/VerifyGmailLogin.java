package com.gmail.TestCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gmail.pages.*;

public class VerifyGmailLogin {

	private WebDriver driver;
	private InboxPage inbox;
	private LoginPage login;

	@Before
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
		login = new LoginPage(driver);
	}

	@Test
	public void loginWithValidUser() throws InterruptedException {

		inbox = login.loginWithValidUser("tribuneqa.device", "s@vuyi24");
		String usern = inbox.getLoggedInUserName();
		inbox.logout();

		Assert.assertEquals("Check LogIn Name", "Tribune", usern);

	}

	@Test
	public void loginWithInValidEmail() throws InterruptedException {

		String error = login.loginWithInValidEmail("tribuneqa.devicee");

		Assert.assertEquals("Check error message for  invalid email ID", "Sorry, Google doesn't recognize that email.", error);

	}

	@Test
	public void loginWithInValidPwd() throws InterruptedException {

		String error = login.loginWithInValidPwd("tribuneqa.device", "s@vuyi244");

		Assert.assertEquals("Check error message for invalid password", "The email and password you entered don't match.", error);

	}

	@After
	public void testTeardown() {

		driver.quit();

	}

}
