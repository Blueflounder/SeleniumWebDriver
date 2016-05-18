package com.LATimes.Gestures;

import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class TouchScreenGestures {

	AndroidDriver driver;

	private Dimension getDeviceSize(AndroidDriver androidDriver) {
		return androidDriver.manage().window().getSize();
	}

	public void swipeRightToLeftPortraitMode(AndroidDriver androidDriver) {
		int startX = (int) (getDeviceSize(androidDriver).width * 0.90);
		int endX = (int) (getDeviceSize(androidDriver).width * 0.10);
		int startY = (int) (getDeviceSize(androidDriver).height * 0.70);

		androidDriver.swipe(startX, startY, endX, startY, 500);
	}

	public void swipeLeftToRightInPortraitMode(AndroidDriver androidDriver) {
		int startX = (int) (getDeviceSize(androidDriver).width * 0.10);
		int endX = (int) (getDeviceSize(androidDriver).width * 0.90);
		int startY = (int) (getDeviceSize(androidDriver).height * 0.70);

		androidDriver.swipe(startX, startY, endX, startY, 500);
	}

	public void swipeSectionFrontNames(AndroidDriver androidDriver) {
		int startX = (int) (getDeviceSize(androidDriver).width * 0.80);
		int endX = (int) (getDeviceSize(androidDriver).width * 0.20);
		int startY = (int) (getDeviceSize(androidDriver).height * 0.20);

		androidDriver.swipe(startX, startY, endX, startY, 300);
	}
	// public void swipeUsingJavaScriptExecutor(){
	//
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// HashMap<String, Double> swipeObject = new HashMap<String, Double>();
	// swipeObject.put("startX", 0.01);
	// swipeObject.put("startY", 0.5);
	// swipeObject.put("endX", 0.9);
	// swipeObject.put("endY", 0.6);
	// swipeObject.put("duration", 3.0);
	// js.executeScript("mobile: swipe", swipeObject);
	// }

	public void swipeUsingTouchActions() {

	}

	public void scrollDownVertically(AndroidDriver androidDriver) {

		Dimension dimensions = androidDriver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.9;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.3;
		int scrollEnd = screenHeightEnd.intValue();
		androidDriver.swipe(0, scrollStart, 0, scrollEnd, 2000);

	}

	public void scrollUpVertically(AndroidDriver androidDriver) {

		Dimension dimensions = androidDriver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.35;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.9;
		int scrollEnd = screenHeightEnd.intValue();
		androidDriver.swipe(0, scrollStart, 0, scrollEnd, 2000);

	}

}
