package org.covid;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.LibGlobal;

public class CovidIndia extends LibGlobal {
	
	public CovidIndia() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tbody")
	private WebElement tableBody; 
	
	@FindBy(id="tablepress-96_next")
	private WebElement btnNext;

	public WebElement getTableBody() {
		return tableBody;
	}

	public WebElement getBtnNext() {
		return btnNext;
	}
}
