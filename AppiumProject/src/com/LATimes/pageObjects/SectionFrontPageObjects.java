package com.LATimes.pageObjects;

import java.util.*;
//import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import com.LATimes.Gestures.*;

public abstract class SectionFrontPageObjects {

	AndroidDriver<WebElement> androidDriver;
	String currentSectionName, nextSectionName;
	int i;
	List<WebElement> sectionNames;
	List<WebElement> sections;
	int getlastTabIndex, currentTabIndex;
	TouchScreenGestures tsg;

	public SectionFrontPageObjects(AndroidDriver<WebElement> androidDriver) {
		this.androidDriver = androidDriver;
		sectionNames = androidDriver.findElementsById("tabTitle");
		tsg = new TouchScreenGestures();
		System.out.println("Sections available currently are: "+sectionNames.size());
	}

	private int getlastTabIndex() {
//		System.out.println(sectionNames.size());
		return sectionNames.size() - 1;
	}
	
	public int getSizeOfSections(){
		
	
		List<String> sectionNamesList = new ArrayList<String>();
		androidDriver.findElementByClassName("android.widget.ImageButton").click();
		List<WebElement> lables = androidDriver.findElementsById("lbl_list_item");
		for (WebElement tab : lables){
			String attributeValue = tab.getAttribute("text").toString();
			if (attributeValue.contains("Edit Sections")) {
				tab.click();
				break;
			}
		}
		List<WebElement> sections = androidDriver.findElementsById("nav_sections_text");
		
		for(WebElement section: sections){
			sectionNamesList.add(section.getText());
		}
		
		System.out.println("Sections added in the list are: "+sectionNamesList);
		System.out.println("Number of available sections are: "+sections.size());
		
		Dimension dimensions = androidDriver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		androidDriver.swipe(0,scrollStart,0,scrollEnd,1000);
		
		for(int i=0; i < sections.size(); i++){
			
			System.out.println(sections.get(i).getText());
			
			for(WebElement sectionName : sections){
				
				
				
			}
			
//			if(!(PreviousName = "Saved" && checked = false))
//				list.add("")
		}
		
//		System.out.println(list.size());
//		return list.size();
		return 1;
		
		
	}

	public int getSelectedTabTitleIndex() throws InterruptedException {
		Thread.sleep(1000);
		int index = 0;
		for (WebElement tab : sectionNames) {
			String attributeValue = tab.getAttribute("selected").toString();
			if (attributeValue.contains("true")) {
				index++;
				break;
			}
			else{
				
			}
			
		}
		return index;
	}

	private void clickTabNextToSelectedTab() throws InterruptedException {
		sectionNames.get(getSelectedTabTitleIndex() + 1).click();
	}

	public String getSelectedTabTitle() throws InterruptedException {
		String tabTitleValue = null;
		for (WebElement tab : sectionNames) {
			String attributeValue = tab.getAttribute("selected").toString();
			if (attributeValue.contains("true")) {
				tabTitleValue = tab.getAttribute("text");
				break;
			}
		}
		return tabTitleValue;
	}

	public boolean swipeThroughSectionFrontToTheRight() throws InterruptedException {

		boolean tabTitlesMatch = true;
		String selectedTabTitleBefore = null;
		String selectedTabTitleAfter = null;
		int noOfSections = 0;

		while (getlastTabIndex() != getSelectedTabTitleIndex()) {
			selectedTabTitleBefore = getSelectedTabTitle();
			System.out.println("Currently visible sections are: "+sectionNames.size());
			System.out.println("Selected tab index is: "+getSelectedTabTitleIndex());
			if(noOfSections != 14){
				tsg.swipeRightToLeftPortraitMode(androidDriver);
			}
			else{
				break;
			}
			
//			clickTabNextToSelectedTab();
			selectedTabTitleAfter = getSelectedTabTitle();

			if (selectedTabTitleBefore == selectedTabTitleAfter) {
				tabTitlesMatch = false;
				break;
			}
		}
		return tabTitlesMatch;

	}

	public void swipeThroughSectionFrontToTheLeft() {

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

		// sectionFrontTitles.get(2).click();

	}

	public void verifyThatUserCanFollowTopicsFromSectionFront() {

	}

	public void verifyThatUserCanReadArticles() {

	}
	


}
