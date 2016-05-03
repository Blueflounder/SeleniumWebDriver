package com.LATimes.pageObjects;

import java.util.List;

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
	int getlastTabIndex, currentTabIndex;

	public SectionFrontPageObjects(AndroidDriver<WebElement> androidDriver) {
		this.androidDriver = androidDriver;
		sectionNames = androidDriver.findElementsById("tabTitle");
	}

	// System.out.println("Number of available sections are: " +
	// sectionNames.size());
	TouchScreenGestures tsg = new TouchScreenGestures();

	private int getlastTabIndex() {
//		System.out.println(sectionNames.size());
		return sectionNames.size() - 1;
	}

	public int getSelectedTabTitleIndex() throws InterruptedException {
		Thread.sleep(1000);
		int index = 0;
		for (WebElement tab : sectionNames) {
			String attributeValue = tab.getAttribute("selected").toString();
			if (attributeValue.contains("true")) {
				break;
			}
			index++;
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

		while (getlastTabIndex() != getSelectedTabTitleIndex()) {
			selectedTabTitleBefore = getSelectedTabTitle();

			clickTabNextToSelectedTab();
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
