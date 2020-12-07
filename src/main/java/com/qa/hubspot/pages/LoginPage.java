package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	//By locators - OR
	private By emailId = By.xpath("//input[@name='email']");
	private By password = By.xpath("//input[@name='password']");
	private By loginButton = By.cssSelector(".ui.large.fluid");
	private By signUpLink = By.linkText("Sign Up");
	
	//Constructor of the Page 
	public LoginPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver=driver;
	}
	
	//Actions
	public String getLoginPageTittle() {
		//return driver.getTitle();
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 5);
	}
	
	public boolean isSignUpLinkExist() {
		//return driver.findElement(signUpLink).isDisplayed();
		return elementUtil.doIsDisplayed(signUpLink);
	}
	
	public HomePage doLogin(String un, String pwd) {
//		driver.findElement(emailId).sendKeys(un);
//		driver.findElement(password).sendKeys(pw);
//		driver.findElement(loginButton).click();
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new HomePage(driver);
	}

}
