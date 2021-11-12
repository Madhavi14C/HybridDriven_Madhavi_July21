package com.technocredits.orghrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.pages.DashboardPage;

public class DashboardTest extends TestBase {

	@BeforeClass
	public void setUp() {
		super.setup();
	}

	@Test
	public void verfiyWidgetsTest() {

		System.out.println("Verify - Dashboard page title");
		DashboardPage dashboardPage = new DashboardPage();
		String expectedDashboardPageHeaderTitle = "Dashboard";
		String actualDashboardPageHeaderTitle = dashboardPage.getPageHeaderTile();
		softAsset.assertEquals(actualDashboardPageHeaderTitle, expectedDashboardPageHeaderTitle);

		String expectedDashboardPageTitle = "Dashboard";
		String actualDashboardPageTitle = dashboardPage.getPageTitle();
		softAsset.assertEquals(actualDashboardPageTitle, expectedDashboardPageTitle);

		System.out.println("Check - total 12 widgets are disply on Dashboard page");
		int totalWidgets = dashboardPage.getTotalWidgets();
		softAsset.assertEquals(totalWidgets, 12);
		softAsset.assertAll();

		System.out.println("STEP - Get all widgets name");
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Quick Access");
		expectedList.add("Buzz Latest Posts");
		expectedList.add("Employee Job Details");
		expectedList.add("My Actions");
		expectedList.add("Headcount by Location");
		expectedList.add("Employees on Leave Today");
		expectedList.add("Time At Work");
		expectedList.add("Performance Quick Feedback");
		expectedList.add("Annual basic payment by Location");
		expectedList.add("Latest Documents");
		expectedList.add("Latest News");
		expectedList.add("Yearly New Hires");

		List<String> actualWidgetsList = dashboardPage.getAllWidgetsText();
		System.out.println("VERIFY - widget names");
		Assert.assertTrue(actualWidgetsList.equals(expectedList));
	}

	@AfterClass
	public void browserClose() {
		super.browserClose();
	}
}
