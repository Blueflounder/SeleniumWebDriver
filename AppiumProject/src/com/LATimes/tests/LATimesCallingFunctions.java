package com.LATimes.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import com.LATimes.sectionFrontPages.TopNewsPage;

import io.appium.java_client.android.AndroidDriver;

public class LATimesCallingFunctions {

	AndroidDriver androidDriver;
	Properties p;
	TopNewsPage tp;

	@Parameters({ "device_Name", "device_ServerPort", "platform_Name", "app_Activity", "app_package" })
	@BeforeTest(alwaysRun = true)
	public void testSetUp(String device_Name, String device_ServerPort, String platform_Name, String app_Activity,
			String app_package) throws InterruptedException, IOException, MalformedURLException {

		p = Utilities.GetObject();

		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability("deviceName", device_Name);
		capabilities.setCapability("platformName", platform_Name);
		capabilities.setCapability("appActivity", app_Activity);
		// capabilities.setCapability("app-wait-activity",
		// "com.apptivateme.next.la/com.tribune.universalnews.MainActivity");
		capabilities.setCapability("appPackage", app_package);
		capabilities.setCapability("unicodeKeyboard", "true");
		capabilities.setCapability("resetKeyboard", "true");

		androidDriver = new AndroidDriver(new URL(p.getProperty("node_URL")), capabilities);
		androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		tp = new TopNewsPage(androidDriver);

	}

	@Test(enabled = false)
	public void verifyThatUserCanSwipeThroughSectionFronts() throws InterruptedException {

		boolean sectionSwipeStatus = tp.swipeThroughSectionFrontToTheRight("Saved", "Columnists & Critics");

		System.out.println("Value returned is " + sectionSwipeStatus);
		Assert.assertEquals(true, sectionSwipeStatus, "User was able to swipe through sections fronts to and fro SUCCESSFULLY");
		if (sectionSwipeStatus == true)
			System.out.println("User was able to swipe through sections fronts to and fro SUCCESSFULLY");
		else
			System.out.println("User was NOT able to swipe through sections fronts to and fro successfully");
	}

	@Test(enabled = false)
	public void verifyThatUserCanJumpToASection() throws InterruptedException{
		
//		String sectionToBeJumpedTo = "Real Estate";
		boolean jumpToSectionStatus = tp.jumpToASection("Real Estate", tp.getNumberOfSections());
		Assert.assertEquals(true, jumpToSectionStatus, "User was able to JUMP to a section SUCCESSFULLY");
		if (jumpToSectionStatus == true)
			System.out.println("User was able to JUMP to the section successfully");
		else
			System.out.println("User was NOT able to JUMP to a section successfully");
		
	}
	
	@Test(enabled = true)
	public void verifyThatUserCanScrollThroughArticles() throws InterruptedException{
		
		tp.scrollingThroughArticlesOnASectionFront();
		
	}
	
	@AfterTest(alwaysRun = true)
	public void Exit() {
		androidDriver.closeApp();
		androidDriver.quit();
	}

}
