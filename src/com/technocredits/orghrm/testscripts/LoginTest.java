 package com.technocredits.orghrm.testscripts;

//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LoginPage;

public class LoginTest {
	SoftAssert softAsset = new SoftAssert();

	@BeforeMethod
	public void setup() {
		PredefinedActions.start();
	}

	@Test
	public void loginTest() {
		System.out.println("Verify - Logo displayed is present on login Page");
		LoginPage loginPage = new LoginPage();
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAsset.assertTrue(isLogoDisplayed, "Logo was not displayed on Login Page");

		System.out.println("Verify - Login Panel displayed on Login Page");
		boolean isLoginPanelDisplayed = loginPage.isLoginPanelDisplayed();
		softAsset.assertTrue(isLoginPanelDisplayed, "LoginPanel was not displayed on Login Page");

		System.out.println("STEP - Enter Credentials");
		loginPage.enterCredentials("Admin", "1rG3xE@RKp");
		softAsset.assertAll();

		System.out.println("Click on Login button");
		loginPage.clickOnLoginButton();
	}

	@AfterMethod
	public void browserClose() {
		PredefinedActions.browserClose();
	}
}
