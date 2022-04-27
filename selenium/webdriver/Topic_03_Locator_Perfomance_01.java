package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Locator_Perfomance_01 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Test
	public void TC_01() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
	
		//find element băng id 10k lần
		for (int i= 0; i < 1000; i++) {
			System.out.println("ID lần thứ: " +i);
			driver.findElement(By.id("email"));
			} 
		driver.quit();
	}
	
		@Test
		public void TC_02_CSS() {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
			//find element băng CSS 10k lần
			for (int i= 0; i < 1000; i++) {
				System.out.println("CSS lần thứ: " +i);
				driver.findElement(By.cssSelector("input[id='email']"));
				} 
			driver.quit();	
		}
		
		@Test
		public void TC_03_ID() {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
			//find element băng Xpath 10k lần
			for (int i= 0; i < 1000; i++) {
				System.out.println("Xpath lần thứ: " +i);
				driver.findElement(By.xpath("//input[@id='email']"));
				} 
			driver.quit();	
		}	
}