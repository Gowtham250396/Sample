package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

public class LibGlobal {

	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static JavascriptExecutor js=(JavascriptExecutor)driver;
	public static Set<String> allWindowID;
	public static String ParentId; 
	public static Scanner sc=new Scanner(System.in);
	public static Select s;
	public static String excelRead(int i,int j) throws IOException {
		File f=new File("C:\\Users\\god\\eclipse-workspace\\Sample\\workbook\\New Microsoft Office Excel Worksheet.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fi);
		Sheet s=w.getSheet("Sheet1");		
			Row r= s.getRow(i);
			Cell c = r.getCell(j);
			int cellType = c.getCellType();
		String value="";
			if (cellType==1) {
			
			value = c.getStringCellValue();
			
		}else if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			value = sdf.format(d);
			
		}else {
			double dd = c.getNumericCellValue();
			long l=(long)dd;
			value = String.valueOf(l);
			
		}
		
		return value;	
		
	}
	public static void excelWrite(int a,int b,String text) throws IOException {
		
		File f=new File("C:\\Users\\god\\eclipse-workspace\\Sample\\workbook\\New Microsoft Office Excel Worksheet.xlsx");
		FileInputStream fin=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(a);
		Cell c = r.createCell(b);
		c.setCellValue(text);
		FileOutputStream fout=new FileOutputStream(f);
		w.write(fout);
		
	}
	
	
	public static void chromeBrowser() {
	   
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\god\\eclipse-workspace\\SeleniumDay1\\Driver\\chromedriver.exe");
	   driver=new ChromeDriver();
	}
	public static void firefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\god\\eclipse-workspace\\SeleniumDay1\\Driver\\geckodriver.exe");
		driver=new FirefoxDriver();

	}
	public static void iEBrowser() {
		System.setProperty("webdriver.ie.driver","C:\\Users\\god\\eclipse-workspace\\SeleniumDay1\\Driver\\IEDriverServer.exe");
		driver =new InternetExplorerDriver();
	}
	public static void launchURL(String url) {
		driver.get(url);
	}
	public static void maxBrowser() {
		driver.manage().window().maximize();
	}
	public static void fill(WebElement element,String input) {
		element.sendKeys(input);
	}
	public static void btnclick(WebElement element) {
		element.click();
	}
	public static void pagetitle() {
		driver.getTitle();
	}
	public static void pageurl() {
		driver.getCurrentUrl();
	}
	public static void performDragAndDrop(WebElement src,WebElement dsc) {
	 a=new Actions(driver);
	 a.dragAndDrop(src,dsc).perform();
	}
	public static void rightclick(WebElement click) {
		a.contextClick(click).perform();
	}
	public static void twoClick(WebElement click) {
		a.doubleClick(click).perform();;
	}
	public static void enter() throws AWTException  {
		r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void tab() {
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	public static void copy() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	public static void cut() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}
	public static void paste() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	public static void closeBrowser() {
		driver.quit();
	}
	public static void navigateURL(String url) {
		driver.navigate().to(url);
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static void back() {
		driver.navigate().back();
	}
	public static void forward() {
		driver.navigate().forward();
	}
	public static void screenshot(String output) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dsc=new File("C:\\Users\\god\\eclipse-workspace\\SeleniumDay1\\Screenshot\\"+output+".png");
		FileUtils.copyFile(src, dsc);
	}
	public static void scrollUp(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public static void scrollDown(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	
	}
	public static void jsFill(WebElement element,String input) {
		js.executeScript("arguments[0].setAttribute('value',"+input+")",element);
	}
	public static void jsGet(WebElement element) {
		Object o = js.executeScript("arguments[0].getAttribute('value')",element);
		String s=(String)o;
		System.out.println(s);
	}
	public static void jsClick(WebElement element) {
		js.executeScript("arguments[0].click()",element);
	
	}
	public static void parentWindowId() {
		 ParentId = driver.getWindowHandle();
		
	}
	public static void allWindow() {
	 allWindowID = driver.getWindowHandles();
		
	}
	public static void Switch() {
		for (String s : allWindowID) {
		if (!(ParentId==s)) {
			driver.switchTo().window(s);
		}}
	}
	public static void simplealert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	public static void confirmalert() {
		Alert a = driver.switchTo().alert();
		String alert = a.getText();
		System.out.println(alert);
		System.out.println("Enter 1 to accept or 2 to Reject the alert");
		int result = sc.nextInt();
		if (result==1) {
			a.accept();
		} else {
			a.dismiss();
		}
	}
	public static void promptAlert() {
		Alert a = driver.switchTo().alert();
		String alert = a.getText();
		System.out.println(alert);
		System.out.println("Enter the Input In TextField");
		String text = sc.nextLine();
		a.sendKeys(text);
		System.out.println("Enter 1 to accept or 2 to Reject the alert");
		int result = sc.nextInt();
			if (result==1) {
				a.accept();
			} else {
				a.dismiss();
			}
		}
	
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		}

	
	public static void newtab(WebElement element) {
		rightclick(element);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void newWindow(WebElement element) {
		rightclick(element);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void Selectbyindex(WebElement element,int a) {
		s=new Select(element);
		s.selectByIndex(a);
	}
	public static void Selectbyvalue(WebElement element,String value) {
		s=new Select(element);
		s.selectByValue(value);
	}
	public static void Selectbyvisibletext(WebElement element,String value) {
		s=new Select(element);
		s.selectByVisibleText(value);
	}
	public static void deselect() {
		s.deselectAll();
	}
	public static void deSelectbyindex(WebElement element,int a) {
		s=new Select(element);
		s.deselectByIndex(a);
	}
	public static void deSelectbyvalue(WebElement element,String value) {
		s=new Select(element);
		s.deselectByValue(value);
	}
	public static void deSelectbyvisibletext(WebElement element,String value) {
		s=new Select(element);
		s.deselectByVisibleText(value);
	}

	
}

