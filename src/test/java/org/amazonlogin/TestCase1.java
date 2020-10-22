package org.amazonlogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.test.LibGlobal;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase1 extends LibGlobal {
	
	@BeforeClass
	private void launch() {
		chromeBrowser();
		launchURL("https://www.amazon.in/");
		implicitWait();
	}
	@Test
	private void loginMain() throws InterruptedException {
		Thread.sleep(5000);
		Login l=new Login();
		Actions a=new Actions(driver);
		a.moveToElement(l.getSignIn());
		a.moveToElement(l.getBtnsign());
		btnclick(l.getBtnsign());
		fill(l.getUserName(), "8110014035");
		btnclick(l.getBtnCntue());
		fill(l.getPassword(), "Gowtham@25");
		btnclick(l.getBtnLogin());
		
	}
	@Test(dataProvider="searchDetails")
	private void search(String options) {
		Login l1=new Login();
		fill(l1.getTxtSearchBox(), options);
		btnclick(l1.getBtnSearch());
		List<WebElement> results = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("Total No Of Results in "+options+" Results: "+results.size());
	}
	
	
	@DataProvider(name="searchDetails")
	private Object[][] searchOptions() {
		return new Object[][] {
			{"Dell Laptop"},
			{"Samsung Mobile Phones"},
			{"Micromax LEDTV"},
			{"iphone11"}
				
		};

	}
	
			
	}
