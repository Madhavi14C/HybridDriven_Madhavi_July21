package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;

import com.technocredits.orghrm.base.PredefinedActions;

public class PIM_EmployeeListPage extends PredefinedActions {

	public PIM_EmployeeListPage searchAddedEmp(String empName) {
		driver.findElement(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")).sendKeys(empName);
		return this;
	}

	public PIM_EmployeeListPage clickOnSearch() {
		driver.findElement(By.id("quick_search_icon")).click();
		return this;
	}

	public boolean isEmployeeAdded(String empName) {
		return driver.findElement(By.xpath("//table[@id='employeeListTable']//td[text()='" +empName+ "']")).isDisplayed();
	}
}
