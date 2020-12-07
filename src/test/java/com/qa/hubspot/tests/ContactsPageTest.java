package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class ContactsPageTest extends BaseTest {
	
	
	
	@BeforeClass
	public void homePageSetup() {
	homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	contactsPage = homePage.goToContactsPage();
	}
	
	@Test 
	public void verifyContactsPageTitleTest(){
		String title = contactsPage.getContactsPageTitle();
		System.out.println("Contacts page title is: "+ title);
		Assert.assertEquals(Constants.CONTACTS_PAGE_TITLE, title);
	}
	
	@Test
	public void createContact() {
		contactsPage.createContacts("Telman", "Emin", "kral");
	}

}
