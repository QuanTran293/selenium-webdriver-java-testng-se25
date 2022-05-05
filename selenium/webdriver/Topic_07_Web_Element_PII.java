package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Web_Element_PII {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	//@Test
	public void TC_01_Displayed() {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	
	WebElement emailTextbox = driver.findElement(By.cssSelector("#mail"));
	if (emailTextbox.isDisplayed()) {
		emailTextbox.sendKeys("Automation Testing");
		 System.out.println("Email textbox is displayed");
	} else {  
		System.out.println("Email textbox is not displayed");
		 }
	
	WebElement ageUnder18Radio = driver.findElement(By.cssSelector("#under_18"));
	if (ageUnder18Radio.isDisplayed()) {
		ageUnder18Radio.click();
		 System.out.println("Age under 18 radio is displayed");
	} else {  
		System.out.println("Age under 18 radio is not displayed");
		 }
	
	WebElement educationTextarea = driver.findElement(By.cssSelector("#edu"));
	if (educationTextarea.isDisplayed()) {
		educationTextarea.sendKeys("Automation Testing");
		 System.out.println("Educatrion textarea is displayed");
	} else {  
		System.out.println("Educatrion textarea is not displayed");
	
	}
		
		WebElement name5Text = driver.findElement(By.cssSelector("#edu"));
		if (name5Text.isDisplayed()) {
			name5Text.sendKeys("Automation Testing");
			 System.out.println("Name 5 text is displayed");
		} else {  
			System.out.println("Name 5 text is not displayed");
	}
	}

	//@Test
	public void TC_02_Enable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		// Enable
		WebElement emailTextbox = driver.findElement(By.cssSelector("#mail"));
		if (emailTextbox.isEnabled()) {
			 System.out.println("Email textbox is enabled");
		} else {  
			System.out.println("Email textbox is disabled");
			 }
		
		WebElement educationTextarea = driver.findElement(By.cssSelector("#edu"));
		if (educationTextarea.isEnabled()) {
			System.out.println("Email textbox is enabled");
		} else {  
			System.out.println("Email textbox is disabled");
		}
		
		// Disable
		WebElement job3Dropdown = driver.findElement(By.cssSelector("#job3"));
		if (job3Dropdown.isEnabled()) {
			 System.out.println("Job 3 dropdown is enabled");
		} else {  
			System.out.println("Job 3 dropdown is disabled");
		}
	}
	
	//@Test
	public void TC_03_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		WebElement ageUnder18Radio = driver.findElement(By.cssSelector("#under_18"));
		WebElement javaCheckbox = driver.findElement(By.cssSelector("#java"));
		
		ageUnder18Radio.click();
		javaCheckbox.click();
		
		// Verify 2 fields là selected
		Assert.assertTrue(ageUnder18Radio.isSelected());
		Assert.assertTrue(javaCheckbox.isSelected());
		
		if (ageUnder18Radio.isSelected()) {
			System.out.println("Age under 18 is selected");
		} else {
			System.out.println("Age under 18 is deselected");
		}
		
		if (javaCheckbox.isSelected()) {
			System.out.println("Java checkbox is selected");
		} else {
			System.out.println("Java checkbox is deselected");
		}
		
		ageUnder18Radio.click();
		javaCheckbox.click();
		
		Assert.assertTrue(ageUnder18Radio.isSelected());
		Assert.assertFalse(javaCheckbox.isSelected());
		
		if (ageUnder18Radio.isSelected()) {
			System.out.println("Age under 18 is selected");
		} else {
			System.out.println("Age under 18 is deselected");
		}
		
		if (javaCheckbox.isSelected()) {
			System.out.println("Java checkbox is selected");
		} else {
			System.out.println("Java checkbox is deselected");
		}
		
	}

	@Test
	public void TC_04_Mailchimp() {
		driver.get("https://login.mailchimp.com/signup/");
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
		driver.findElement(By.cssSelector("input#new_username")).sendKeys("automationfc");
		
		WebElement passwordTextbox =  driver.findElement(By.cssSelector("input#new_password"));
		WebElement signupButton = driver.findElement(By.cssSelector("button#create-account"));
		
		
		// Lowercase
		passwordTextbox.sendKeys("auto");
		sleepInSecond (1);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed' and text ()='One lowercase character']")).isDisplayed());
		Assert.assertFalse(signupButton.isEnabled());
		
		// Uppercase
		passwordTextbox.clear();
		passwordTextbox.sendKeys("KKKK");
		sleepInSecond (5);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed' and text()='One uppercase character']")).isDisplayed());
		Assert.assertFalse(signupButton.isEnabled());
		
		// Number
		passwordTextbox.clear();
		passwordTextbox.sendKeys("123456");
		sleepInSecond (1);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed' and text ()='One number']")).isDisplayed());
		Assert.assertFalse(signupButton.isEnabled());
		
		// Special
		passwordTextbox.clear();
		passwordTextbox.sendKeys("!@#");
		sleepInSecond (1);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed' and text ()='One special character']")).isDisplayed());
		Assert.assertFalse(signupButton.isEnabled());
		
		// Special
		passwordTextbox.clear();
		passwordTextbox.sendKeys("12345678");
		sleepInSecond (1);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed' and text ()='One number']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed' and text ()='8 characters minimum']")).isDisplayed());		
		Assert.assertFalse(signupButton.isEnabled());
		
		// Combie
		passwordTextbox.clear();
		passwordTextbox.sendKeys("Auto123!@#");
		sleepInSecond (1);
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()=\"Your password is secure and you're all set!\"]")).isDisplayed());		
		Assert.assertTrue(signupButton.isEnabled());
		
		
	}
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	public void sleepInSecond(long timeInSecond) {
	try {
		Thread.sleep(timeInSecond * 1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}	
}