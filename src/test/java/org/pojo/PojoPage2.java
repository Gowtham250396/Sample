package org.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.LibGlobal;


public class PojoPage2 extends LibGlobal {
	public PojoPage2() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="location")
	private WebElement city;
	
	@FindBy(id="hotels")
	private WebElement hotel;
	
	@FindBy(id="room_type")
	private WebElement roomType;
	
	@FindBy(id="Submit")
	private WebElement search;

	public WebElement getCity() {
		return city;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getSearch() {
		return search;
	}
	

}
