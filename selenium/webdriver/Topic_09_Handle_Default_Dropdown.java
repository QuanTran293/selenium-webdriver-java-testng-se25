package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Handle_Default_Dropdown {
	WebDriver driver;
	Select select;
	String firstName, lastName, day, month, year, companyName, password, emailAddress;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		firstName = "Barack"; 
		lastName = "Obama"; 
		day = "20"; 
		month = "May"; 
		year = "1960"; 
		companyName = "White House"; 
		password = "123456";
		emailAddress = "barackobama" + generateRandomNumber() +"@hotmail.net"; 
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

	@Test
	public void TC_01_nopcommerce() {
		driver.get("https://demo.nopcommerce.com/register");
		
		// Action ( input data)
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		
		//  Dropdown
		// Khi nao dùng để thao tác vs Element thì mới khởi tạo
		select = new Select (driver.findElement(By.name("DateOfBirthDay")));
		
		// Thao tác vs Dropdown
		// <select name="DateOfBirthDay" class="valid" aria-invalid="false">
		// <option value="0">Day</option>
		// <option value="1">1</option>
		// <option value="2">2</option>
		// <option value="3">3</option>
		// <option value="4">4</option>
		// <option value="5">5</option>
		// ...
		// </select>
		
		// Index là thứ tự của thẻ option
		//select.selectByIndex(1);
		//select.selectByIndex(5);
		
		// Value: Giá trị của thuộc tính value
		//select.selectByValue("5");
		//select.selectByValue("10");
		
		// Text: Item text
		//select.selectByVisibleText("Day");
		//select.selectByVisibleText("5");
		
		// Chọn Day
		select.selectByVisibleText(day);
		// Kiểm tra đã chọn được hay chưa
		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);
		
		
		// Chọn Month
		select = new Select (driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText(month);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		
		// Chọn Year
		select = new Select (driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText(year);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);		
		
		
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Company")).sendKeys(companyName);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
		driver.findElement(By.id("register-button")).click();
		
		// Ouput Data
		Assert.assertEquals(driver.findElement(By.className("result")).getText(), "Your registration completed");
		driver.findElement(By.className("ico-account")).click();
		
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName); 
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName); 
		
		//day
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);
		
		//month
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		
		//year
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
		
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailAddress); 
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName); 
	
		
		
		
		
	}

	@Test
	public void TC_02_ValidatePageTitle() {
		
	}

	@Test
	public void TC_03_LoginFormDisplayed() {
		
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