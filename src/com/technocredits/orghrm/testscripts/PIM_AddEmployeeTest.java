package com.technocredits.orghrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.MenuPage;
import com.technocredits.orghrm.pages.PIM_AddEmployeePage;

public class PIM_AddEmployeeTest extends TestBase {

	private MenuPage menuPage;

	@BeforeMethod
	public void setUp() {
		menuPage = super.setup();
	}

	@Test
	public void verifyAddEmpTest() {
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
		pim_AddEmployeePage.setEmpFirstName("Sergei").setEmpMiddleName("T").setEmpLastName("Falin")
				.setEmployeeLocation("Canadian Regional HQ").clickOnNext().setHobbies("Travelling").clickOnNext()
				.setWorkShift("General").setEffectiveFrom("12").setRegion("Region-1").setFTE("1")
				.setTemporary_Department("Sub unit-1").clickOnSave();
		Assert.assertTrue(pim_AddEmployeePage.savedSuccessfully());
	}
	@AfterMethod
	public void browserClose() {
		super.browserClose();
	}
}
