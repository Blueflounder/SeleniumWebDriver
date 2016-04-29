package com.LATimes.Gestures;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class TouchScreenGestures {
	
	public void swipeRightToLeftPortraitMode(AndroidDriver androidDriver){
		androidDriver.swipe(640, 1340, 100, 1340, 300);
	}
	
	public void swipeLeftToRightInPortraitMode(AndroidDriver androidDriver){
		androidDriver.swipe(100, 1340, 740, 1340, 300);
		
	}

}
