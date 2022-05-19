package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Alert {
	WebDriver driver;
	Alert alert;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

//	@Test
	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	
		
		// switch qua alert
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "I am a JS Alert"); 
		
		alert.accept();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");
	}

//	@Test
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/");
		driver.findElement(By.xpath("//button[text()=\"Click for JS Confirm\"]")).click();
	
		
		// switch qua alert
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "I am a JS Confirm"); 
		
		// cancel: alert.dismiss();
		alert.accept();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Ok");
		
		
	}

//	@Test
	public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/");
		driver.findElement(By.xpath("//button[text()=\"Click for JS Prompt\"]")).click();
		
		// switch qua alert
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "I am a JS prompt"); 
		
		alert.sendKeys("quan");
		alert.accept();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: quan");
		
		
	}

//	@Test
	public void TC_04_Authentication_Alert_I() {
		String username = "admin";
		String password = "admin";
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		sleepInSecond(2);
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).getText(), "Congratulations! You must have the proper credentials.");
	}
	
//		@Test
		public void TC_04_Authentication_Alert_II() {
			String username = "admin";
			String password = "admin";
			
			driver.get("http://the-internet.herokuapp.com/");
			
			String basicAuthenLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
			System.out.println(basicAuthenLink);
			
			String[] basicAuthen = basicAuthenLink.split("//");	
		
			// 0 http:
			// 1 the-internet.herokuapp.com/basic_auth
		
			basicAuthenLink = basicAuthen[0] + "//" + username + ":" + password + "@" + basicAuthen[1];
			System.out.println(basicAuthenLink);
			
			driver.get(basicAuthenLink);
			
			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	}
		
		
		@Test
		public void TC_04_Authentication_Alert_III() {
			String username = "admin";
			String password = "admin";
			
			driver.get("http://the-internet.herokuapp.com/");
			
			String basicAuthenLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
					
			basicAuthenLink = getAuthenticateLink(basicAuthenLink, username, password);
			driver.get(basicAuthenLink);
			
			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
		}
			public String getAuthenticateLink(String url, String username, String password) {
				String[] links = url.split("//");
				url = links[0] + "//" + username + ":" + password + "@" + links[1];
				return url;
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