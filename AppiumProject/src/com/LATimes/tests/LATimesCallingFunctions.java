package com.LATimes.tests;
import org.testng.annotations.*;

import com.LATimes.sectionFrontPages.TopNewsPage;

import io.appium.java_client.android.AndroidDriver;

public class LATimesCallingFunctions {

	AndroidDriver androidDriver;

	TopNewsPage tp = new TopNewsPage(androidDriver);

	@Test
	public void verifySwipingThroughSectionFrontsRightToLeft() {

		tp.verifyThatUserCanSwipeThroughSectionFrontPagesRightToLeft();

	}

}
