package com.technocredits.orghrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import com.technocredits.orghrm.base.PredefinedActions;

public class DashboardPage extends PredefinedActions {

	public String getPageTitle() {
		return driver.findElement(By.xpath("//li[@class='page-title']")).getText();
	}

	public String getPageHeaderTile() {
		return driver.getTitle();
	}

	public int getTotalWidgets() {
		return driver.findElements(By.xpath("//div[@id='widget.id']")).size();
	}

	public List<String> getAllWidgetsText() {
		return getTextOfAllElements("//div[@class='widget-header']/span[2]");
	}

	public String getWidgetTextBasedOnIndex(int index) {
		List<String> widgetsList = getAllWidgetsText();
		return widgetsList.get(index);
	}

}
