package org.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.LibGlobal;

public class PojoPage1 extends LibGlobal {
	public PojoPage1() {
		PageFactory.initElements(driver, this);

	}
	@FindBy(id="username")
	private WebElement textUserName;

	@FindBy(id="password")
	private WebElement textPass;

	@FindBy(id="login")
	private WebElement btnLogin;

	public WebElement getTextUserName() {
		return textUserName;
	}

	public WebElement getTextPass() {
		return textPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	
	}	

}
