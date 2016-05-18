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

	// public void swipeRightToLeftPortraitMode(AndroidDriver<WebElement>
	// androidDriver){
	// androidDriver.swipe(640, 1340, 100, 1340, 300);
	// }
	//
//	 public void swipeLeftToRightInPortraitMode(AndroidDriver<WebElement> androidDriver){
//	 androidDriver.swipe(100, 1340, 740, 1340, 300);
//	
//	 }

	public void swipeRightToLeftPortraitMode(AndroidDriver androidDriver) {
		int startX = (int) (getDeviceSize(androidDriver).width * 0.80);
		int endX = (int) (getDeviceSize(androidDriver).width * 0.20);
		int startY = (int) (getDeviceSize(androidDriver).height * 0.70);

		androidDriver.swipe(startX, startY, endX, startY, 200);
	}

	public void swipeLeftToRightInPortraitMode(AndroidDriver androidDriver) {
		int startX = (int) (getDeviceSize(androidDriver).width * 0.20);
		int endX = (int) (getDeviceSize(androidDriver).width * 0.80);
		int startY = (int) (getDeviceSize(androidDriver).height * 0.70);

		androidDriver.swipe(startX, startY, endX, startY, 200);
	}
	
	public void swipeSectionFrontNames(AndroidDriver androidDriver) {
		int startX = (int) (getDeviceSize(androidDriver).width * 0.80);
		int endX = (int) (getDeviceSize(androidDriver).width * 0.20);
		int startY = (int) (getDeviceSize(androidDriver).height * 0.20);

		androidDriver.swipe(startX, startY, endX, startY, 300);
	}
//	public void swipeUsingJavaScriptExecutor(){
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
//		swipeObject.put("startX", 0.01);
//		swipeObject.put("startY", 0.5);
//		swipeObject.put("endX", 0.9);
//		swipeObject.put("endY", 0.6);
//		swipeObject.put("duration", 3.0);
//		js.executeScript("mobile: swipe", swipeObject);
//	}
	
	public void swipeUsingTouchActions(){
		
		
	}
	
	public void scrollDownVertically(AndroidDriver androidDriver){
		
		Dimension dimensions = androidDriver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.01;
		int scrollEnd = screenHeightEnd.intValue();
		androidDriver.swipe(0, scrollStart, 0, scrollEnd, 1000);
		
	}
	
	public void scrollUpVertically(AndroidDriver androidDriver){
		
		Dimension dimensions = androidDriver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		System.out.println("screenHeightStart is: "+screenHeightStart);
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		System.out.println("screenHeightEndt is: "+screenHeightEnd);
		androidDriver.swipe(0,scrollEnd, 0, scrollStart, 1000);
		
	}

}
