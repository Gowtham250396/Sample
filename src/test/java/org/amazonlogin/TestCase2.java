package org.amazonlogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.LibGlobal;
import org.testng.annotations.Test;

public class TestCase2 extends LibGlobal {
	
	@Test
	private void duplicates() {
		List<WebElement> results =driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		for (WebElement result : results) {
			String txt = result.getText();
			if (!(txt.startsWith("Apple"))) {
				
			System.out.println("the Unmatched Results: "+txt);
				
			}
		}
	}

}
