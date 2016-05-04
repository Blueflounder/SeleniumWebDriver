package com.LATimes.tests;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.LATimes.sectionFrontPages.TopNewsPage;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class LATimesCallingFunctions {

	AndroidDriver<WebElement> androidDriver;
	Properties p;

	TopNewsPage tp;
	
	@Parameters({"device_Name", "device_ServerPort", "platform_Name", "app_Activity", "app_package"})
	@BeforeTest(alwaysRun = true)
	public void testSetUp(String device_Name, String device_ServerPort, String platform_Name, String app_Activity, String app_package) throws InterruptedException, IOException{
		
		p = Utilities.GetObject();
//		p.getProperty("APPIUM_ANDROID_SERVER_IP");
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability("deviceName", device_Name);
		capabilities.setCapability("platformName", platform_Name);
		capabilities.setCapability("appActivity", app_Activity);
//		capabilities.setCapability("app-wait-activity", "com.apptivateme.next.la/com.tribune.universalnews.MainActivity");
		capabilities.setCapability("appPackage", app_package);
		capabilities.setCapability("unicodeKeyboard", "true");
		capabilities.setCapability("resetKeyboard", "true");
		
		androidDriver = new AndroidDriver<WebElement>(new URL("http://10.20.121.77:8001/wd/hub"), capabilities);
		androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		tp = new TopNewsPage(androidDriver);
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public void verifySwipingThroughSectionFrontsRightToLeft() throws InterruptedException {

		tp.swipeThroughSectionFrontToTheRight();
		boolean userIsAbleToNavigate = tp.swipeThroughSectionFrontToTheRight();
		
		
		//Assertion
		Assert.assertEquals(true, userIsAbleToNavigate);

	}
	
	@Test(enabled = true)
	public void getSizeOfSections(){
		tp.getSizeOfSections();
	}
	
//	@AfterTest(alwaysRun = true)
//	public void Exit() {
//		androidDriver.quit();
//	}

}
