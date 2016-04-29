package com.LATimes.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import com.LATimes.Gestures.*;

public class SectionFrontPageObjects {

	AndroidDriver androidDriver;
	String currentSectionName, nextSectionName;
	int i;
	
	List<WebElement> sectionNames = androidDriver.findElementsById("tabTitle");
//	System.out.println("Number of available sections are: " + sectionNames.size());
	TouchScreenGestures tsg = new TouchScreenGestures();

	public void verifyThatUserCanSwipeThroughSectionFrontPagesRightToLeft() {

		for (i = 2; i < sectionNames.size(); i++) {
			
//			currentSectionName = sectionNames.get(i).getText();
			tsg.swipeRightToLeftPortraitMode(androidDriver);
			
		}
		nextSectionName = sectionNames.get(i).getText();
//		if(currentSectionName!=nextSectionName)
			
	}

	public void verifyThatUserCanSwipeThroughSectionFrontPagesLeftToRight() {

		for (int i = sectionNames.size(); i > 0; i--) {
			
			tsg.swipeRightToLeftPortraitMode(androidDriver);

		}

	}
	
	public void verifyThatUserCanScrollThroughSectionFrontArticles() {

		List<WebElement> sectionNames = androidDriver.findElementsById("tabTitle");
		System.out.println("Number of available sections are: " + sectionNames.size());
		for (int i = sectionNames.size(); i > 0; i--) {

		}

	}

	public void verifyThatUserCanSaveArticlesFromSectionFront() {
		int articleIndex = 0;

//		sectionFrontTitles.get(2).click();

	}
	
	public void verifyThatUserCanFollowTopicsFromSectionFront(){
		
	}
	
	public void verifyThatUserCanReadArticles(){
		
	}

}
