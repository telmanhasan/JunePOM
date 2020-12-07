package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {
	
	ElementUtil elementUtil;
	private WebDriver driver;
	
	private By firstName = By.xpath("//input[@name='first_name']");
	private By lastName = By.xpath("//input[@name='last_name']");
	private By position  = By.xpath("//input[@name='position']");
	private By saveButton = By.xpath("//button[normalize-space()='Save']");
	
	public ContactsPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	public String getContactsPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.CONTACTS_PAGE_TITLE, 5);
	}
	
	public void createContacts(String name, String last, String positionjob) {
		elementUtil.clickWhenReady(firstName, 5);
		elementUtil.doSendKeys(firstName, name);
		elementUtil.doSendKeys(lastName, last);
		elementUtil.doSendKeys(position, positionjob);
		elementUtil.doClick(saveButton);
	}
	
	
	

}
