package org.covid;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.LibGlobal;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.LaunchSuite;

public class WebTable extends LibGlobal {

	@BeforeClass
	private void launch() {
		chromeBrowser();
		launchURL("https://covidindia.org/");
		implicitWait();
	}
	@Test
	private void table() {
	CovidIndia cd=new CovidIndia();
	basemethod(cd);
	btnclick(cd.getBtnNext());
	CovidIndia cd1=new CovidIndia();
	basemethod(cd1);
	btnclick(cd1.getBtnNext());
	CovidIndia cd2=new CovidIndia();
	basemethod(cd2);
	btnclick(cd2.getBtnNext());
	CovidIndia cd3=new CovidIndia();
	basemethod(cd3);
	btnclick(cd3.getBtnNext());

	}
	private void basemethod(Object o) {
	List<WebElement> tableRows = ((CovidIndia) o).getTableBody().findElements(By.tagName("tr"));
	for (WebElement tableRow : tableRows) {
		List<WebElement> tableColumns = tableRow.findElements(By.tagName("td"));
		
		
			WebElement stateName = tableColumns.get(0);
			String state = stateName.getText();
			WebElement cases = tableColumns.get(1);
			String confirmedCases = cases.getText();
			System.out.println(state+" = "+confirmedCases);
		
	}
	
		
	}
	
		
	
	
}
