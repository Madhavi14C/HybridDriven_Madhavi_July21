package com.technocredits.orghrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.MenuPage;
import com.technocredits.orghrm.pages.PIM_EmployeeListPage;

public class PIM_EmployeeListTest extends TestBase {

	private MenuPage menuPage;

	@BeforeMethod
	public void setUp() {
		menuPage = super.setup();
	}

	@Test
	public void employeeSearch() {
		System.out.println("STEP - Navigate to PIM->Employee List");
		menuPage.navigateTo("PIM->Employee List");
		PIM_EmployeeListPage pim_EmployeeListPage = new PIM_EmployeeListPage();
		System.out.println("STEP -Search added Employee name using search option");
		pim_EmployeeListPage.searchAddedEmp("Sergei T Falin").clickOnSearch();
		Assert.assertTrue(pim_EmployeeListPage.isEmployeeAdded("Sergei T Falin "));

	}

	@AfterMethod
	public void browserClose() {
		super.browserClose();
	}
}
