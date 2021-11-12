package com.technocredits.orghrm.pages;

//import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;

public class UserProfilePage extends PredefinedActions {

	public void clickOnUserDropdown() {
		driver.findElement(By.xpath("//a[@id='user-dropdown']")).click();
	}
	
	public static List<String> getListOfUserDropDownOptions() {
		return getTextOfAllElements("//ul[@id='user_menu']/li/a");
	
	}
	
	public static int getTotalAvailableOptions() {
		return getListOfUserDropDownOptions().size();
	}
	
	public static void clickOnAbout() {
		driver.findElement(By.xpath("//ul[@id='user_menu']//a[text()='About']")).click();
	}
	
	public void clickOnSubMenu(String subMenu) {
		driver.findElement(By.xpath("//ul[@id='user_menu']//a[text()='"+subMenu+"']")).click();
	}
	
	public String getCmpNameFromAboutPopup() {
		return driver.findElement(By.xpath("//div[@id='companyInfo']/div/div[1]/p")).getText();
	}
	
	public static List<String> getAboutMenuText(){
		return getTextOfAllElements("//div[@id='companyInfo']//p");
		
	}
	public static void clickOnOk() {
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
	}
	
}
