package webdriver;

import static org.testng.Assert.assertEquals;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Colors;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Handle_Button_RadioButton_CheckBox_Alert {
	WebDriver driver;
	
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		jsExecutor = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	//@Test
	public void TC_01_Button() {
		driver.get("https://www.fahasa.com/customer/account/create");
		driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
		
		By loginButtonBy = By.cssSelector("button.fhs-btn-login");
		
		// Verify login button is Disable
		Assert.assertFalse(driver.findElement(loginButtonBy).isEnabled());
		
		driver.findElement(By.xpath("//input[@id=\"login_username\"]")).sendKeys("automationfc@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"login_password\"]")).sendKeys("automationfc");
		sleepInSecond(1);
		
		Assert.assertTrue(driver.findElement(loginButtonBy).isEnabled());
		
		//Veriffy mau background = RED
		String loginButtonBackgroundColorRgb = driver.findElement(loginButtonBy).getCssValue("background-color");
		System.out.println("Hexa color = " + loginButtonBackgroundColorRgb);
		
		//Verify = RGB
		Assert.assertEquals(loginButtonBackgroundColorRgb, "rgb(201, 33, 39)");
		
		// convert qua Hexa
		//String loginButtonBackgroundColorHexa = Colors.fromString(loginButtonBackgroundColorRgb).asHex();
		//System.out.println("Hexa color = " + loginButtonBackgroundColorHexa);
		
		//Assert.assertEquals(loginButtonBackgroundColorHexa.toUpperCase(), "#C92127");
		
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
		
		// Remove disable attribute
		jsExecutor.executeScript("arguments[0].removeAttribute('disabled');", driver.findElement(loginButtonBy));
		sleepInSecond(2);
		
		driver.findElement(loginButtonBy).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='popup-login-content']//label[text()='Số điện thoại/Email']/following-sibling::div[@class='fhs-input-alert']")).getText(), "Thông tin này không thể để trống");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='popup-login-content']//label[text()='Mật khẩu']/following-sibling::div[@class='fhs-input-alert']")).getText(), "Thông tin này không thể để trống");
		
		

	}

	//@Test
	public void TC_02_DefaultRadioButton() {
		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
		
		By oneDotEightPetroRadio = By.xpath("//label[text()='1.8 Petrol, 118kW']/preceding-sibling::input");
		By twoDotZeroPetroRadio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input");
		By threeDotSixPetroRadio = By.xpath("//label[text()='3.6 Petrol, 191kW']/preceding-sibling::input");
		
		Assert.assertFalse(driver.findElement(oneDotEightPetroRadio).isSelected());
		
		driver.findElement(oneDotEightPetroRadio).click();
		sleepInSecond(2);
		
		Assert.assertTrue(driver.findElement(oneDotEightPetroRadio).isSelected());
		
		driver.findElement(twoDotZeroPetroRadio).click();
		sleepInSecond(2);
		
		// Deselected
		Assert.assertFalse(driver.findElement(oneDotEightPetroRadio).isSelected());
		
		//Selected
		Assert.assertTrue(driver.findElement(twoDotZeroPetroRadio).isSelected());
		
		//Enable
		Assert.assertTrue(driver.findElement(oneDotEightPetroRadio).isEnabled());
		Assert.assertTrue(driver.findElement(twoDotZeroPetroRadio).isEnabled());
		
		//Disable
		Assert.assertFalse(driver.findElement(threeDotSixPetroRadio).isEnabled());
		
		
	}

	//@Test
	public void TC_03_Default_Checkbox() {
driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		
		By luggageCheckbox = By.xpath("//label[text()='Luggage compartment cover']/preceding-sibling::input");
		By heatedCheckbox = By.xpath("//label[text()='Heated front and rear seats']/preceding-sibling::input");
		By towbarCheckbox = By.xpath("//label[text()='Towbar preparation']/preceding-sibling::input");
		By leatherCheckbox = By.xpath("//label[text()='Leather trim']/preceding-sibling::input");
		
		
		//select
		if (!driver.findElement(luggageCheckbox).isSelected()) {
			driver.findElement(luggageCheckbox).click();
		 }
		
		if (!driver.findElement(heatedCheckbox).isSelected()) {
		driver.findElement(heatedCheckbox).click();
		}
		
		// Selected
		// checkToCheckbox (luggageCheckbox);
		// checkToCheckbox (heatedCheckbox);
		// Assert.assertTrue(isElementSelected(luggageCheckbox)); viet ngan lai
		// Assert.assertTrue(isElementSelected(heatedCheckbox)); viet ngan lai
		// Assert.assertTrue(isElementSelected(leatherCheckbox)); viet ngan lai
		 
		Assert.assertTrue(driver.findElement(luggageCheckbox).isSelected());
		Assert.assertTrue(driver.findElement(heatedCheckbox).isSelected());
		Assert.assertTrue(driver.findElement(leatherCheckbox).isSelected());
		
		// Verify thuoc tinh Disable
		Assert.assertFalse(driver.findElement(towbarCheckbox).isEnabled());
		Assert.assertFalse(driver.findElement(leatherCheckbox).isEnabled());
		
		// Deselect
		// uncheckToCheckbox (towbarCheckbox);
		// uncheckToCheckbox (towbarCheckbox);
				if (driver.findElement(luggageCheckbox).isSelected()) {
					driver.findElement(luggageCheckbox).click();
				 }
				
				if (driver.findElement(heatedCheckbox).isSelected()) {
				driver.findElement(heatedCheckbox).click();
				}
		
		// Verify - Deselected
		Assert.assertFalse(driver.findElement(luggageCheckbox).isSelected());
		Assert.assertFalse(driver.findElement(heatedCheckbox).isSelected());
		Assert.assertFalse(driver.findElement(towbarCheckbox).isSelected());
	}
	
	@Test
	public void TC_04_Multiple_Checkbox() {
		driver.get("https://automationfc.github.io/multiple-fields/");

		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println("Checkbox size = " + checkboxes.size());
		
		//action -Select
		for (WebElement checkbox : checkboxes) {
			if (!checkbox.isSelected()) {
			checkbox.click();
			//sleepInMiliSecond(500);
		}
		}
		// verify -Select
		for (WebElement checkbox : checkboxes) {
			Assert.assertTrue(checkbox.isSelected());
		}
		
		//action - Deselect
		for (WebElement checkbox : checkboxes) {
			if (checkbox.isSelected()) {
				checkbox.click();
				//sleepInMiliSecond(500);
				}
		}
		// verify - Deselect
		for (WebElement checkbox : checkboxes) {
			Assert.assertFalse(checkbox.isSelected());
	
				}
		
	}
	public void checkToCheckbox (By by) {
		if (!driver.findElement(by).isSelected()) {
			driver.findElement(by).click();
		}
	}

	public void uncheckToCheckbox (By by) {
		if (driver.findElement(by).isSelected()) {
			driver.findElement(by).click();
		
		}
		}
	
	
	public boolean isElementSelected (By by) {
		if (driver.findElement(by).isSelected()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isElementEnable (By by) {
		if (driver.findElement(by).isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSecond(long second) {
	try {
		Thread.sleep(second * 1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void sleepInMiliSecond(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}