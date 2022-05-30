package webdriver;

import static org.testng.Assert.assertEquals;

import java.awt.color.ColorSpace;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Actions_Part_II {
	WebDriver driver;
	Actions action;
	JavascriptExecutor jsExecutor;
	WebDriverWait expliciWaitl;
	String projectPath = System.getProperty("user.dir");
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		action = new Actions(driver);
		jsExecutor = (JavascriptExecutor) driver;
		expliciWaitl = new WebDriverWait(driver, 10);
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

//	@Test
	public void TC_01_Double_Click() {
	driver.get("https://automationfc.github.io/basic-form/index.html");	
	// doi vs Firefox can phai Scroll xuong de chay
	WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double click me']"));
		
	action.doubleClick(doubleClickButton).perform();
	sleepInSecond(3);
	
	Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Hello Automation Guys!']")).getText(), "Hello Automation Guys!");
		
		
	}	
	
//	@Test
	public void TC_02_Right_Click() {
	driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	
	action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
	sleepInSecond(3);
		
	// hover vao thang paste
	action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
	sleepInSecond(3);
	
	// verify thang paste dc hove thanh cong
	Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste.context-menu-hover.context-menu-visible")).isDisplayed());
	
	// click vao paste
	action.click(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
	sleepInSecond(3);
	
	// accpet alert sau khi click
	expliciWaitl.until(ExpectedConditions.alertIsPresent()).accept();	
		
		
	}	
//	@Test
	public void TC_03_Drag_And_Drop_HMTL4() {
	driver.get("https://automationfc.github.io/kendo-drag-drop/");
	
	WebElement smallCirle = driver.findElement(By.id("draggable"));
	WebElement bigCirle = driver.findElement(By.id("droptarget"));
	
	action.dragAndDrop(smallCirle, bigCirle).perform();
	sleepInSecond(3);
	
	//Text
	Assert.assertEquals(bigCirle.getText(), "You did great!");
	
	//background
	Assert.assertEquals(Color.fromString(bigCirle.getCssValue("background-color")).asHex().toLowerCase(), "#03a9f4");
	
	// phan tich code Color.fromString(bigCirle.getCssValue("background-color")).asHex().toLowerCase()
	// bigCirle.getCssValue("background-color") lay ra ma RGBA
	// require la Hexa => chuyen ve Hexa
	// Color.fromString => String cua thu vien color
	// asHex(): #03a9f4
	// toLowerCase(): chuyen thanh viet thuong
	
	System.out.println(bigCirle.getCssValue("background-color"));
	System.out.println(Color.fromString(bigCirle.getCssValue("background-color")).asHex());
	System.out.println(Color.fromString(bigCirle.getCssValue("background-color")).asHex().toLowerCase());
	
	
	}
	@Test
	public void TC_04_Drag_And_Drop_HMTL5_Css() {
	driver.get("https://automationfc.github.io/drag-drop-html5/");
	
	WebElement squareA = driver.findElement(By.id("column-a"));
	WebElement squareB = driver.findElement(By.id("column-b"));
	
	action.dragAndDrop(squareA, squareB).perform();
	sleepInSecond(3);
					
	// 1 trong nhung TC ko nen lam auto
	// mat nhieu thoi gian de lam nhung ko on dinh
	// ROI
	// Drag drop
	// captcha
	// chart
	// sms
	// otp
	// authentication code
	// map
	// calendar
	// ocr
	
	
		
	}	
	
	public void TC_05_Drag_And_Drop_HMTL5_Xpath() {
	
		
		
		
		
		
	}
	
	
//	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSecond(long timeInSecond) {
	try {
		Thread.sleep(timeInSecond * 1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}	
}