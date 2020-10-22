package org.amazonlogin;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.LibGlobal;
import org.testng.annotations.Test;

public class TestCase3 extends LibGlobal {
  public String prices;
	@Test
	private void filters() {
				List<WebElement> search = driver.findElements(By.xpath("//div[@data-index]"));
				for (int i = 2; i < (search.size()+2); i++) {
					WebElement searchResult = search.get(i);
				WebElement result = searchResult.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			
				WebElement priceTag = searchResult.findElement(By.xpath("//span[@class='a-price-whole']"));
				String txt = priceTag.getText();
				prices="";
				System.out.println(prices);
				for (int j = 0; j < txt.length(); j++) {
				char a = txt.charAt(j);
				if ((a=='0')||(a=='1')||(a=='2')||(a=='3')||(a=='4')||(a=='5')||(a=='6')||(a=='7')||(a=='8')||(a=='9')) { 
			    prices=prices+a;
			    System.out.println(prices);
					}
				int parseInt = Integer.parseInt(prices);
		  	
				if (parseInt > 50000) {
					
					
						System.out.println("Filter Results: "+result.getText()+" rs."+parseInt);
					
			
		}
		
	}

}}}
