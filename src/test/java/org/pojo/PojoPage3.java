package org.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.LibGlobal;

public class PojoPage3 extends LibGlobal  {
	 public PojoPage3() {
			PageFactory.initElements(driver, this);
		}
		 
		 @FindBy(id="radiobutton_0")
		 private WebElement radio;
		 
		 @FindBy(id="continue")
		 private WebElement cont;

		public WebElement getRadio() {
			return radio;
		}

		public WebElement getCont() {
			return cont;
		}
	

}
