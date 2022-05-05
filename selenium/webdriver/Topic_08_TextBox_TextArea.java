package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_TextBox_TextArea {
	// Khai báo
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	
	// Biến Global thuộc phạm vi class
	String emailAddress, loginUrl, userID, password;
	String customerName, genderValueOutput, dateOfBirthInput,dateOfBirthOutput , addressInput, addressOutput , city, state, pinNumber, phoneNumber;

	// Khai báo và khởi tạo
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// ép kiểu tường minh
		jsExecutor = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
		
		loginUrl = driver.getCurrentUrl();
		
		// Khởi tạo dữ liệu
		emailAddress = "johndeep" + generateRandomNumber() + "@hotmail.net";
		customerName = "john Deep"; 
		genderValueOutput = "male"; 
		dateOfBirthInput = "08/15/1960"; 
		dateOfBirthOutput = "1960-08-15"; 
		addressInput = "123 PO\nLos Angeles\nUnited State"; 
		addressOutput = "123 PO Los Angeles United State"; 
		city = "Hawaii"; 
		state = "Los Angeles"; 
		pinNumber = "126589"; 
		phoneNumber = "0987566325";
		
	}

	@Test
	public void TC_01_Register () {
		driver.findElement(By.xpath("//a[text()='here']")).click();
		
		// suggest code - CTRL + SPACE
		// Home
		// End
		
		driver.findElement(By.name("emailid")).sendKeys(emailAddress);
		
		driver.findElement(By.name("btnLogin")).click();
		
		// phạm vi local ( chỉ thuộc method này)
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}

	@Test
	public void TC_02_Login () {
		driver.get(loginUrl);
		
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		// Verify trang HP display
		// lấy text ra driver.findElement(By.xpath("//td[text()='Manger Id : mngr400122']")).getText();
		Assert.assertEquals(driver.findElement(By.cssSelector("tr.heading3>td")).getText() , "Manger Id : " + userID);	
	}

	@Test
	public void TC_03_Create_New_Customer() {
		// input
		driver.findElement(By.xpath("//a[text()='New Customer']")).click(); 
		driver.findElement(By.name("name")).sendKeys(customerName);
		driver.findElement(By.xpath("//input[@value='m']")).click();
	
		WebElement dateOfBirthTextbox = driver.findElement(By.name("dod"));
		jsExecutor.executeScript("argument[0].removeAttribute('disabled')" ,dateOfBirthTextbox);
		sleepInSecond(3);
		dateOfBirthTextbox.sendKeys(dateOfBirthInput);
		
		
		driver.findElement(By.name("addr")).sendKeys(addressInput);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("pinno")).sendKeys(pinNumber);
		driver.findElement(By.name("telephoneno")).sendKeys(phoneNumber);
		driver.findElement(By.name("emailid")).sendKeys(emailAddress);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("sub")).click();
	
		// output > verify
		Assert.assertEquals(driver.findElement(By.cssSelector("p.heading3")).getText() , "Customer Registered Successfully!!!");	
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), customerName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), genderValueOutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthday']/following-sibling::td")).getText(), dateOfBirthOutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), dateOfBirthOutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pinNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phoneNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), emailAddress);
		
		
	}	
		
		
		
	@Test
	public void TC_04_LoginFormDisplayed() {
		
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