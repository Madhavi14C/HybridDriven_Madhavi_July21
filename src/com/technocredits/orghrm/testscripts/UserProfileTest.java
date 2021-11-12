package com.technocredits.orghrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.UserProfilePage;

public class UserProfileTest extends TestBase{

	@BeforeClass
	public void setUp() {
		super.setup();
	}

	@Test
	public void verfiyUserMenuOptions() {
		System.out.println("Verify UserMenuDropDown options");
		UserProfilePage userProfilePage=new UserProfilePage();
		
		System.out.println("STEP - click on user Dropdown Option");
		userProfilePage.clickOnUserDropdown();
		
		System.out.println("Verify - List of User DropDown options");
		List<String> expectedListOptions = new ArrayList<String>();
		expectedListOptions.add("About");
		expectedListOptions.add("Change Password");
		expectedListOptions.add("Logout");
		
		List<String> actaualListOptions = UserProfilePage.getListOfUserDropDownOptions();
		System.out.println("VERIFY - dropdown  options");
		Assert.assertTrue(actaualListOptions.equals(expectedListOptions));
		
		System.out.println("Verify - Size of User DropDown options");
		int totaloptions=UserProfilePage.getTotalAvailableOptions();
		softAsset.assertEquals(totaloptions, 3);
		softAsset.assertAll();
		
		System.out.println("Click on About option");
		UserProfilePage.clickOnAbout();
		
		System.out.println("STEP - Get all About text names");
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Company Name: OrangeHRM (Pvt) Ltd(Parallel Demo)");
		expectedList.add("Version: OrangeHRM 7.2.159485");
		expectedList.add("Employees: 95 (305 more allowed)");
		expectedList.add("Users: 77 (723 more allowed)");
		expectedList.add("Renewal on: Wed, 01 Jun 2022");
		
		List<String> actuaList= UserProfilePage.getAboutMenuText();
		System.out.println("VERIFY - About text names");
		Assert.assertTrue(actuaList.equals(expectedList));

		System.out.println("Click on Ok button");
		UserProfilePage.clickOnOk();
	
	}
	@AfterClass
	public void browserClose() {
		super.browserClose();
	}
}
