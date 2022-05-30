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

public class Topic_12_Fix_Popup {
	WebDriver driver;
	
	String projectPath = System.getProperty("user.dir");
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

	@Test
	public void TC_01_NgoaiNgu24h() {
	driver.get("https://ngoaingu24h.vn/");
	
	By loginPopup = By.cssSelector("div#modal-login-v1");
	
	// Verify log in popup is not displayed
	Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
	sleepInSecond(2);
	
	driver.findElement(By.cssSelector("button.login_")).click();
	
	// Verify log in popup is displayed
	Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
	
	driver.findElement(By.cssSelector("input#account-input")).sendKeys("automationtest");
	driver.findElement(By.cssSelector("input#password-input")).sendKeys("automationtest");
	driver.findElement(By.cssSelector("button.btn-login-v1")).click();
	sleepInSecond(2);
	
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"modal-login-v1\"]//div[@class=\"row error-login-panel\"]")).getText(),"Tài khoản không tồn tại!");
	
	driver.findElement(By.cssSelector("div#modal-login-v1 button.close")).click();
	sleepInSecond(2);
	
	// Verify log in popup is not displayed
	Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
	sleepInSecond(2);
	
	
	// Nếu như dùng By: Element này động/ có thể bị refresh lại sau các step tiếp theo (cùng 1 trang)
	// Nếu như dùng WebElement: Element này luôn luôn cố định/ ko bị thay đổi status/ ko bị update lại HTML 
	
	}	
	@Test
	public void TC_02_Right_Click() {
	
		
		
	}	
	@Test
	public void TC_03_Drag_And_Drop_HMTL4() {
	
	
	}
	@Test
	public void TC_04_Drag_And_Drop_HMTL5_Css() {
	
	
	
		
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