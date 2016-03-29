package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By Email = By.id("Email");
	By nextButton = By.id("next");
	By password = By.id("Passwd");
	By signInButton = By.id("signIn");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public InboxPage loginWithValidUser(String eid, String pwd) {

		driver.findElement(Email).sendKeys(eid);
		driver.findElement(nextButton).click();
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		
		return new InboxPage(driver);
	}
	
	public String loginWithInValidEmail(String eid) {
		
		String errorMessage;

		driver.findElement(Email).sendKeys(eid);
		driver.findElement(nextButton).click();
				
		errorMessage = driver.findElement(By.id("errormsg_0_Email")).getText();
		
		return errorMessage;
	}
	
	public String loginWithInValidPwd(String eid, String pwd) {
		
		String errorMessage;

		driver.findElement(Email).sendKeys(eid);
		driver.findElement(nextButton).click();
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		
		errorMessage = driver.findElement(By.id("errormsg_0_Passwd")).getText();
		
		return errorMessage;
	}
}



