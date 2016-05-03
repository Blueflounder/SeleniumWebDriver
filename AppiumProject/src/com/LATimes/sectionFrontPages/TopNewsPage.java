package com.LATimes.sectionFrontPages;

import org.openqa.selenium.WebElement;
import com.LATimes.pageObjects.SectionFrontPageObjects;
import io.appium.java_client.android.AndroidDriver;

public class TopNewsPage extends SectionFrontPageObjects {

	AndroidDriver<WebElement> androidDriver;
	
	public TopNewsPage(AndroidDriver<WebElement> androidDriver) {
		super(androidDriver);
		// TODO Auto-generated constructor stub
	}

}
