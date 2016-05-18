package com.LATimes.pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.LATimes.Gestures.TouchScreenGestures;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import io.appium.java_client.android.AndroidDriver;

public abstract class SectionFrontPageObjects {

	AndroidDriver androidDriver;
	List<WebElement> sectionFrontNames, listOfSectionNames, Articles;
	TouchScreenGestures tsg;
	boolean tabTitlesMatch = true;
	String tabTitleBeforeSwipe, tabTitleAfterSwipe;
	int noOfSections;

	public SectionFrontPageObjects(AndroidDriver androidDriver) {
		this.androidDriver = androidDriver;
		sectionFrontNames = androidDriver.findElementsById("tabTitle");
		tsg = new TouchScreenGestures();
	}

	public int getNumberOfSections() {

		System.out.println("Getting number of sections");
		// Declaring list to save the section names
		List<String> sectionNamesList = new ArrayList<String>();
		androidDriver.findElementByAccessibilityId("Open navigation drawer").click();
		List<WebElement> menuList = androidDriver.findElementsById("lbl_list_item");
		for (WebElement menuName : menuList) {
			String attributeValue = menuName.getAttribute("text").toString();
			if (attributeValue.contains("Edit Sections")) {
				menuName.click();
				break;
			}
		} // end of for each

		int lastIndex;

		for (int i = 0; i < 6; i++) {
			
			// Adding section names to list while swiping
			listOfSectionNames = androidDriver.findElementsById("nav_sections_text");

			for (WebElement sectionName : listOfSectionNames) {
				sectionNamesList.add(sectionName.getText());
			}

			lastIndex = listOfSectionNames.size();
			String lastSectionName = listOfSectionNames.get(lastIndex - 1).getText();
			if (lastSectionName.contains("Columnists & Critics"))
				break;
			
			tsg.scrollDownVertically(androidDriver);
		}
		// ArrayList<String> list1 = new ArrayList<String>(new LinkedHashSet<String>(sectionNamesList));

		// Removing duplicate values from the sectionNamesList
		ImmutableList<String> finalSectionList = ImmutableSet.copyOf(sectionNamesList).asList();
		System.out.println("Number of sections available: " + finalSectionList.size());
		androidDriver.findElementByAccessibilityId("Navigate up").click();
		return finalSectionList.size();

	}

	public String getSelectedSectionFrontTitle() throws InterruptedException {
		String sectionFrontTitle = null;
		String attributeValue;
		sectionFrontNames = androidDriver.findElementsById("tabTitle");
		for (WebElement sectionName : sectionFrontNames) {
			attributeValue = sectionName.getAttribute("selected").toString();
			if (attributeValue.contains("true")) {
				sectionFrontTitle = sectionName.getAttribute("text");
				break;
			}
		}

		return sectionFrontTitle;
	}

	public ImmutableList<String> getArticleTitles() throws InterruptedException {

		System.out.println("Getting article titles");
		Thread.sleep(2000);
		// Declaration
		ImmutableList<String> finalArticleList = null;
		List<String> listOfArticles = new ArrayList<String>();
		String firstArticleTitle, lastArticleTitle;
		int lastIndex;

		for (int i = 0; i < 30; i++) {

			Articles = androidDriver.findElementsById("cell_title");
			
			for (WebElement article : Articles) {
				listOfArticles.add(article.getText());
			}
//			finalArticleList = ImmutableSet.copyOf(listOfArticles).asList();
//			lastIndex = finalArticleList.size();
//			lastArticleTitle = finalArticleList.get(lastIndex - 1);
//			System.out.println("Last article of DUPLICATE list is: "+Articles.get(i).getText());
//			System.out.println("Last article of FINAL list is: "+lastArticleTitle);
//			if(Articles.get(i).getText().equals(lastArticleTitle))
//				break;
			
			tsg.scrollDownVertically(androidDriver);
		}

		// Removing duplicate values from the sectionNamesList
		finalArticleList = ImmutableSet.copyOf(listOfArticles).asList();
		System.out.println("Number of articles: " + finalArticleList.size());
		firstArticleTitle = finalArticleList.get(0);
		System.out.println("First article of FINAL list is: "+firstArticleTitle);
		lastIndex = finalArticleList.size();
		lastArticleTitle = finalArticleList.get(lastIndex - 1);
		System.out.println("Last article of FINAL list is: "+lastArticleTitle);
		
		for (int j = 0; j < 45; j++) {
			tsg.scrollUpVertically(androidDriver);
//			Articles = androidDriver.findElementsById("cell_title");
//			if(Articles.get(j-1).getText().equals(lastArticleTitle))
//				break;
		}
		// androidDriver.findElementByAccessibilityId("Navigate up").click();
		return finalArticleList;

	}

	public boolean swipeThroughSectionFrontToTheRight(String firstSectionName, String lastSectionName)
			throws InterruptedException {

		noOfSections = getNumberOfSections();
		System.out.println("No of Sections Received " + noOfSections);
		System.out.println("Swiping to the END of the sections");
		Thread.sleep(1000);

		for (int i = 2; i < noOfSections; i++) {

			tsg.swipeRightToLeftPortraitMode(androidDriver);
			Thread.sleep(300);

		} // end of for loop

		Thread.sleep(1000);
		if (!getSelectedSectionFrontTitle().equals(lastSectionName)) {
			tabTitlesMatch = false;
		}
		tabTitlesMatch = swipeThroughSectionFrontToTheLeft(noOfSections, firstSectionName);
		return tabTitlesMatch;

	}

	public boolean swipeThroughSectionFrontToTheLeft(int j, String firstSectionName) throws InterruptedException {

		System.out.println("Swiping to the START of the sections");

		for (int k = 0; k < j; k++) {

			tsg.swipeLeftToRightInPortraitMode(androidDriver);
			Thread.sleep(300);
		}
		if (!getSelectedSectionFrontTitle().equals(firstSectionName)) {
			tabTitlesMatch = false;
		}
		return tabTitlesMatch;
	}

	public boolean jumpToASection(String sectionNameToBeJumpedTo, int noOfSections) throws InterruptedException {

		boolean userIsJumpedToSection = false;
		String sectionTitle;

		for (int i = 0; i < noOfSections; i++) {

			sectionFrontNames = androidDriver.findElementsById("tabTitle");

			for (WebElement sectionName : sectionFrontNames) {

				sectionTitle = sectionName.getAttribute("text");
				if (sectionTitle.equals(sectionNameToBeJumpedTo)) {
					sectionName.click();
					userIsJumpedToSection = true;
					break;
				}
			}
			if (userIsJumpedToSection)
				break;
			
			tsg.swipeSectionFrontNames(androidDriver);
		}
		return userIsJumpedToSection;
	}

	public boolean scrollingThroughArticlesOnASectionFront() throws InterruptedException {

		// String firstArticleTitle, lastArticleTitle;

		getArticleTitles();

		return true;
	}

}
