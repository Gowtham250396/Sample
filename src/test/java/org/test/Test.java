package org.test;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.Date;
import org.pojo.PojoPage1;
import org.pojo.PojoPage2;
import org.pojo.PojoPage3;
import org.pojo.PojoPage4;
import org.pojo.PojoPage5;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
public class Test extends LibGlobal {
	
	@BeforeClass
	private void launchBrowse() {
			
		chromeBrowser();
		launchURL("http://adactinhotelapp.com/");
		maxBrowser();
		implicitWait();
	}
	
	@AfterClass
	private void quitBrowser() {
		closeBrowser();

	}
	@BeforeMethod
	private void date() {
			Date d=new Date();
			System.out.println(d);
		}
	
	@AfterMethod
	private void date1() {
		Date d=new Date();
		System.out.println(d);
	}
		@org.testng.annotations.Test
		
		public void tc1() throws IOException {
		
		PojoPage1 a=new PojoPage1();
		
		fill(a.getTextUserName(),excelRead(1, 0));
		
		fill(a.getTextPass(), excelRead(1, 1));
		
		btnclick(a.getBtnLogin());
		}
		
		@org.testng.annotations.Test
		
		public void tc2() {
		
		PojoPage2 b=new PojoPage2();
		
		Selectbyvisibletext(b.getCity(), "Melbourne");
		
		Selectbyvisibletext(b.getHotel(), "Hotel Sunshine");
		
		Selectbyvisibletext(b.getRoomType(), "Super Deluxe");
		
		btnclick(b.getSearch());
		}
		@org.testng.annotations.Test
		
		public void tc3() {
		
		
		PojoPage3 c=new PojoPage3();
		
		btnclick(c.getRadio());
		
		btnclick(c.getCont());
		
		}
		@org.testng.annotations.Test
		
		public void tc4() throws IOException {
		
		PojoPage4 e=new PojoPage4();
			
		fill(e.getFname(), excelRead(1,2));
		
		fill(e.getLname(), excelRead(1, 3));
		
		fill(e.getAdd(), excelRead(1, 4));
		
		fill(e.getCcno(), excelRead(1, 5));
		
		Selectbyvisibletext(e.getCctype(), "American Express");
		
		Selectbyvisibletext(e.getCcexpmonth(), "February");

		Selectbyvisibletext(e.getCcexpyear(), "2022");
		
		fill(e.getCvv(),excelRead(1, 6) );
		
		btnclick(e.getBook());
		
		}
		@org.testng.annotations.Test
		private void tc5() throws IOException {
			
		PojoPage5 f=new PojoPage5();
		
		
		String text = f.getOrderno().getAttribute("value");
		System.out.println(text);
		excelWrite(1, 7, text);
		
	}


		
		
		
	}
	
	
	

