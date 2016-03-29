package com.mcall.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	By LogInButton1 = By.xpath("/html/body/header/div[1]/div[1]/a[1]");
	By EmailID = By.xpath("html/body/div[8]/div/div[2]/form/div[1]/fieldset[1]/input");
	By password = By.xpath("html/body/div[8]/div/div[2]/form/div[1]/fieldset[2]/input");
	By LogInButton2 = By.xpath("html/body/div[8]/div/div[2]/form/div[1]/button");
	By EmailID2 = By.xpath("html/body/div[12]/div[2]/div[2]/form/div/fieldset/input");
	By ForgotPwd = By.linkText("I forgot my password");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@SuppressWarnings("deprecation")
	public InboxPage loginWithValidUser(String eid, String pwd) throws InterruptedException {

		//Clicking on Log In button
		driver.findElement(LogInButton1).click();
		
		//Switching to parent window
		String handle1 = driver.getWindowHandle();
		driver.switchTo().window(handle1);
		//Thread.sleep(3000);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.numberOfwindowsToBe(2));
		
		/*wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(handle1));*/
	
		
		//Entering email address
		List<WebElement> emailBox = driver.findElements(By.name("email"));
		emailBox.get(0).sendKeys(eid);
		
		//Entering password
		List<WebElement> pwdBox = driver.findElements(By.name("password"));
		pwdBox.get(0).sendKeys(pwd);
		
		//Clicking on Log In button
		List<WebElement> LogInBtn = driver.findElements(By.className("reg-submit"));
		LogInBtn.get(0).click();
		Thread.sleep(5000);
		

		return new InboxPage(driver);
		
	}

	public String loginWithInValidEmail(String eid, String pwd) {

		String errorMessage;

		driver.findElement(LogInButton1).click(); 
		driver.findElement(EmailID).sendKeys(eid);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(LogInButton2).click();

		errorMessage = driver.findElement(By.xpath("html/body/div[8]/div/div[2]/div[1]/div")).getText();

		return errorMessage;
	}

	public String loginWithInValidPwd(String eid, String pwd) {

		String errorMessage;

		/* driver.findElement(LogInButton1).click(); */
		driver.findElement(EmailID).sendKeys(eid);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(LogInButton2).click();

		errorMessage = driver.findElement(By.xpath("html/body/div[8]/div/div[2]/div[1]/div")).getText();

		return errorMessage;
	}

	public String verifyForgotPwd(String eid) throws InterruptedException {

		String successMessage = null;
		try {

			driver.findElement(LogInButton1).click();
			String handle1 = driver.getWindowHandle();
			driver.switchTo().window(handle1);
			Thread.sleep(2000);

			driver.findElement(ForgotPwd).click();
			List<WebElement> emailBox = driver.findElements(By.name("email"));
			List<WebElement> SendBtn = driver.findElements(By.className("reg-submit"));
			emailBox.get(1).sendKeys(eid);
			SendBtn.get(1).click();
			Thread.sleep(4000);
			
			List<WebElement> successMsg = driver.findElements(By.className("reg-title"));
			successMessage = successMsg.get(1).getText();
		} catch (Exception excep) {

		} finally {
			driver.quit();
		}

		return successMessage;

	}

}
