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
	
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"modal-login-v1\"]//div[@class=\"row error-login-panel\"]")).getText(),"T??i kho???n kh??ng t???n t???i!");
	
	driver.findElement(By.cssSelector("div#modal-login-v1 button.close")).click();
	sleepInSecond(2);
	
	// Verify log in popup is not displayed
	Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
	sleepInSecond(2);
	
	
	// N???u nh?? d??ng By: Element n??y ?????ng/ c?? th??? b??? refresh l???i sau c??c step ti???p theo (c??ng 1 trang)
	// N???u nh?? d??ng WebElement: Element n??y lu??n lu??n c??? ?????nh/ ko b??? thay ?????i status/ ko b??? update l???i HTML 
	
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