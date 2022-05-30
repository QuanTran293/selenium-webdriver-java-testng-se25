package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Actions_Part_I {
	WebDriver driver;
	Actions action;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
			// 1. khoi tao action len
		action = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

//	@Test
	public void TC_01_Hover() {
	driver.get("https://automationfc.github.io/jquery-tooltip/");
			
	WebElement yourAgeTextBox = driver.findElement(By.id("age"));
		
	// Hover chuoojt vafo textbox
	action.moveToElement(yourAgeTextBox).perform();
	sleepInSecond(3);
	
	
	Assert.assertEquals(driver.findElement(By.className("ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
		
	}	
	
//	@Test
	public void TC_02_Hover() {
	driver.get("https://www.myntra.com/");
			
	// 2. Goi ham can dung ra
	// 3. goi cai perform() cuoi cung
	
	action.moveToElement(driver.findElement(By.xpath("//header//a[text()='Kids']"))).perform();
	sleepInSecond(3);
	
	//WebElement khac vs action.click ntn?
	
	action.click(driver.findElement(By.xpath("//header//a[text()='Home & Bath']"))).perform();
	sleepInSecond(3);
	
	
	Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb")).getText(), "Kids Home Bath");
		
	}	
	@Test
	public void TC_03_Click_And_Hold() {
	driver.get("https://automationfc.github.io/jquery-selectable/");
			
	// Khai bao vaf lu truu lai 12 Element
	List<WebElement> allNumbers = driver.findElements(By.cssSelector("ol#selectable>li"));
	
	WebElement firstNumber = allNumbers.get(0);
	WebElement secondNumber = allNumbers.get(1);
	WebElement thirdNumber = allNumbers.get(2);
	WebElement fourthNumber = allNumbers.get(3);
	
	// chon tu 1-4
	// Click and hold thang 1
	action.clickAndHold(firstNumber).moveToElement(fourthNumber).release().perform();
	sleepInSecond(3);
	
	List<WebElement> allNumberSeletec = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
	Assert.assertEquals(allNumberSeletec.size(), 4);
	}	

	
	@Test
	public void TC_04_Click_And_Hold_Random() {
	driver.get("https://automationfc.github.io/jquery-selectable/");
			
	// Khai bao vaf lu truu lai 12 Element
	List<WebElement> allNumbers = driver.findElements(By.cssSelector("ol#selectable>li"));
	
	//Keys controlkey;
	//if(osName.contains("Windows")) {
	//	controlkey = Keys.CONTROL;
	// } else {	
	//	controlkey = Keys.COMMAND;
		
	// Chon 1 va 5 va 11
	// Nhan phim Ctrl xuong (chua nha ra)
	// Click vao 1
	// Click vao 5
	// Click vao 11
	// thuc thi cau lenh
	// nha phim Ctrl ra
	
	// thay CONTROL = controlkey
	action.keyDown(Keys.CONTROL).perform();
	action.click(allNumbers.get(0)).click(allNumbers.get(4)).click(allNumbers.get(10)).perform();
	action.keyUp(Keys.CONTROL).perform();
	sleepInSecond(3);
	
	List<WebElement> allNumberSeletec = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
	Assert.assertEquals(allNumberSeletec.size(), 3);
	
	}	
	@AfterClass
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