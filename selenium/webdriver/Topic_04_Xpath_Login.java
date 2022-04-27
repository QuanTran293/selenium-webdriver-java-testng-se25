package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Xpath_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, fullName, emailAddress, password;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		firstName = "Automation"; 
		lastName = "FC"; 
		fullName = firstName + " " + lastName;
		emailAddress = "afc" + generateRandomNumber() + "@hotmail.com";
		password = "12345678";
	}
	
	@Test
	public void Login_01_Empty_Data() {
		// Mo app ra
		driver.get("http://live.techpanda.org/index.php/");
		
		//  click vao Dang ky button
		//driver.findElement(By.xpath(//div/a[@href="http://live.techpanda.org/index.php/customer/account/"])).click();
		
		// Kiem tra message loi hien thi o cac field bat buoc
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.name("login[password]")).sendKeys("");
		driver.findElement(By.cssSelector("button[title='Login']")).click();
		
		//so sanh 1 chuoi tim duoc vs 1 chuoi mong muon
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
	}	
		
	@Test
	public void Login_02_Invalid_Email() {
			driver.get("http://live.techpanda.org/index.php/");
			driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
			
			driver.findElement(By.id("email")).sendKeys("123@456.123");
			driver.findElement(By.name("login[password]")).sendKeys("123456");
			driver.findElement(By.cssSelector("button[title='Login']")).click();
			
			//so sanh 1 chuoi tim duoc vs 1 chuoi mong muon
			Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");		
		
	}
	@Test
	public void Login_03_Invalid_Password() {
		driver.get("http://live.techpanda.org/index.php/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("automationfc@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("123");
		driver.findElement(By.cssSelector("button[title='Login']")).click();
		
		//so sanh 1 chuoi tim duoc vs 1 chuoi mong muon
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");		
	}
	@Test
	public void Login_04_Incorrect_Email_Password() {
		driver.get("http://live.techpanda.org/index.php/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("automationfc@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("123456789");
		driver.findElement(By.cssSelector("button[title='Login']")).click();
	
		Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(), "Invalid login or password.");		
	}
	
	@Test
	public void Login_05_Create_New_Account() {
		driver.get("http://live.techpanda.org/index.php/");
		
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		driver.findElement(By.name("firstName")).sendKeys(firstName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		driver.findElement(By.name("email")).sendKeys(emailAddress);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmation")).sendKeys(password);
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		 
		//tuyet doi
		//Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
		
		//tuong doi
		String contactInforText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		Assert.assertTrue(contactInforText.contains(fullName));
		Assert.assertTrue(contactInforText.contains(emailAddress));
		
		driver.findElement(By.xpath("//header//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']]")).click();
		
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

	}
	@Test
	public void Login_06_Valid_Email_Password() {
		driver.get("http://live.techpanda.org/index.php/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys(emailAddress);
		driver.findElement(By.name("login[password]")).sendKeys(password);
		driver.findElement(By.cssSelector("button[title='Login']")).click();
	
		String contactInforText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		Assert.assertTrue(contactInforText.contains(fullName));
		Assert.assertTrue(contactInforText.contains(emailAddress));
		
		
	}		
		
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}	
