package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Constants;

public class HomePage extends BasePage {

	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By nameAv = By.xpath("//span[text()='Telman Hasanov']");
	private By dealAv = By.xpath("//span[text()='No deal data available']");
	private By freeAccountIc = By.linkText("Free account");
	private By contactsLink = By.xpath("//span[text()='Contacts']");
	private By newContactsButton = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button");
	
	public HomePage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getNameValue() {
//		if(driver.findElement(nameAv).isDisplayed()) {
//			return driver.findElement(nameAv).getText();
//		}
//		return null;
		if(elementUtil.doIsDisplayed(nameAv)) {
			return elementUtil.doGetText(nameAv);
		}
		return null;
		
	}
	
	public String getDealAv() {
//		if(driver.findElement(dealAv).isDisplayed()) {
//			return driver.findElement(dealAv).getText();
//		}
//		return null;
		if(elementUtil.doIsDisplayed(dealAv)) {
			return elementUtil.doGetText(dealAv);
		}
		return null;
	}
	
	public boolean isFreeAccounIconExist() {
//		return driver.findElement(freeAccountIc).isDisplayed();
		return elementUtil.doIsDisplayed(freeAccountIc);
		
	}
	
	public ContactsPage goToContactsPage() {
		goToCreateNewContact();
		return new ContactsPage(driver);
	}
	
	private void goToCreateNewContact() {
		elementUtil.waitForElementPresent(contactsLink, 5);
		elementUtil.doClick(contactsLink);
		elementUtil.waitForElementPresent(newContactsButton, 5);
		elementUtil.doClick(newContactsButton);
	}



}
