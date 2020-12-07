package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest {
	
	
	
	@BeforeClass
	public void homePageSetup() {
	homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	}

	
	@Test(priority=1)
	public void verifyHomePageTittleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("HomePage Tittle is: "+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyAccountNameTest() {
		String nameValue = homePage.getNameValue();
		System.out.println("Name of the account is: " +nameValue);
		Assert.assertEquals(nameValue, Constants.NAME_OF_ACCOUNT);
	}
	
	@Test(priority=3)
	public void verifyDealAvailabilityTest() {
		String dealAv = homePage.getDealAv();
		System.out.println("Deal Availability is: "+ dealAv);
		Assert.assertEquals(dealAv, Constants.DEAL_AVAILIBILITY);
	}
	
	@Test(priority=4)
	public void verifyFreeAccountIconExistTest() {
		Assert.assertTrue(homePage.isFreeAccounIconExist());
	}
	
	
	
	
	
}
