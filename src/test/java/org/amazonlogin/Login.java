package org.amazonlogin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.LibGlobal;

public class Login extends LibGlobal  {
	
	public Login() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="twotabsearchtextbox")
	private WebElement txtSearchBox;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement btnSearch;

	@FindBy(xpath="//span[text()='Hello, Sign in']")
	private WebElement signIn;
	
	@FindBy(xpath="//span[@class='nav-action-inner']")
	private WebElement btnsign;
	
	@FindBy(id="ap_email")
	private WebElement userName;
	
	@FindBy(id="continue")
	private WebElement btnCntue;
	
	@FindBy(id="ap_password")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement btnLogin;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getBtnCntue() {
		return btnCntue;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	

	public WebElement getBtnsign() {
		return btnsign;
	}

	public WebElement getTxtSearchBox() {
		return txtSearchBox;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	

}
