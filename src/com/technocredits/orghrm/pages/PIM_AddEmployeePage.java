package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghrm.base.PredefinedActions;

public class PIM_AddEmployeePage extends PredefinedActions {

	public PIM_AddEmployeePage setEmpFirstName(String firstname) {
		driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys(firstname);
		return this;
	}

	public PIM_AddEmployeePage setEmpMiddleName(String middlename) {
		driver.findElement(By.xpath("//input[@id='middle-name-box']")).sendKeys(middlename);
		return this;
	}

	public PIM_AddEmployeePage setEmpLastName(String lastname) {
		driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys(lastname);
		return this;
	}

	public PIM_AddEmployeePage setEmployeeLocation(String location) {
		driver.findElement(By.xpath("//i[text()='arrow_drop_down']")).click();
		driver.findElement(By.xpath("//span[text()='" + location + "']//parent::a")).click();
		return this;
	}

	public PIM_AddEmployeePage clickOnNext() {
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		return this;
	}

	public void addEmployeeInfo(String firstname, String middlename, String lastname, String location) {
		setEmpFirstName(firstname);
		setEmpMiddleName(middlename);
		setEmpLastName(lastname);
		setEmployeeLocation(location);
	}

	public PIM_AddEmployeePage setHobbies(String hobbies) {
		driver.findElement(By.xpath("//input[@id='5']")).sendKeys(hobbies);
		return this;
	}

	public PIM_AddEmployeePage setWorkShift(String shiftValue) {
		try {
			driver.findElement(By
					.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input"))
					.click();
		} catch (StaleElementReferenceException staleException) {
			driver.findElement(By
					.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input"))
					.click();
		}

		// WebElement e = driver.findElement(
		// By.xpath("//ul[contains(@class,'dropdown-content
		// select-dropdown')]//span[text()='"+shiftValue+"']"));
		/*
		 * while(!e.isDisplayed()) { e = driver.findElement( By.
		 * xpath("//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"
		 * +shiftValue+"']")); }
		 */
		WebDriverWait wait = new WebDriverWait(driver, 30); // 500 ms
		// wait.until(ExpectedConditions.visibilityOf(e));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='" + shiftValue + "']")));
		element.click();
		return this;
	}

	public PIM_AddEmployeePage setEffectiveFrom(String date) {
		driver.findElement(By.xpath("//label[text()='Effective From']/following-sibling::span//i")).click();
		driver.findElement(
				By.xpath("//input[@id='add_employee_effective_date']//following-sibling::span[1]//div[text()='" + date
						+ "'][contains(@class,'--infocus')]"))
				.click();
		return this;
	}

	public PIM_AddEmployeePage setRegion(String region) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement regionDropDown = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[text()='Region']/preceding-sibling::div/input")));
		regionDropDown.click();

		WebElement regionElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + region + "']")));
		regionElement.click();
		return this;
	}

	public PIM_AddEmployeePage setFTE(String FTE) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement FTEDropDown = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[text()='FTE']/preceding-sibling::div/input")));
		FTEDropDown.click();

		WebElement FTEElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + FTE + "']")));
		FTEElement.click();
		return this;
	}

	public PIM_AddEmployeePage setTemporary_Department(String Department) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement DepartmentropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[text()='Temporary Department']/preceding-sibling::div/input")));
		DepartmentropDown.click();

		WebElement DepartmentElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + Department + "']")));
		DepartmentElement.click();
		return this;
	}
	public PIM_AddEmployeePage clickOnSave() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return this;
	}
	
	public boolean savedSuccessfully() {
		return driver.findElement(By.xpath("//div[text()='Successfully Saved']")).isDisplayed();
	}

}
