package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Xpath_Part_II {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Register_01_Empty_Data() {
		// Mo app ra
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//  click vao Dang ky button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Kiem tra message loi hien thi o cac field bat buoc
		driver.findElement(By.id("txtFirstname-error")).getText();
		
		// Kiem tra 1 dk tra ve la dung
		// Kiem tra 1 dk tra ve la sai
		
		// Kiem tra 1 dk tra ve la mong muon
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		// Mo app ra
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		// nhap lieu
		driver.findElement(By.id("txtFirstname")).sendKeys("Quan Tran");
		driver.findElement(By.id("txtEmail")).sendKeys("123@456@789");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@456@789");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
				
		//  click vao Dang ky button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
				
		// Kiem tra 1 dk tra ve la mong muon
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");

	}

	@Test
	public void Register_03_Incorrect_Confirm_Email() {
		// Mo app ra
				driver.get("https://alada.vn/tai-khoan/dang-ky.html");
				
				// nhap lieu
				driver.findElement(By.id("txtFirstname")).sendKeys("Quan Tran");
				driver.findElement(By.id("txtEmail")).sendKeys("quantran@hotmail.com");
				driver.findElement(By.id("txtCEmail")).sendKeys("quantran@hotmail.vn");
				driver.findElement(By.id("txtPassword")).sendKeys("123456");
				driver.findElement(By.id("txtCPassword")).sendKeys("123456");
				driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
						
				//  click vao Dang ky button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
			
						
				// Kiem tra 1 dk tra ve la mong muon
				Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");

	}

	@Test
	public void Register_04_Password_Less_Than_6_Chars() {
		// Mo app ra
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		// nhap lieu
		driver.findElement(By.id("txtFirstname")).sendKeys("Quan Tran");
		driver.findElement(By.id("txtEmail")).sendKeys("quantran@hotmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("quantran@hotmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("12345");
		driver.findElement(By.id("txtCPassword")).sendKeys("12345");
		driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
				
		//  click vao Dang ky button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
				
		// Kiem tra 1 dk tra ve la mong muon
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}
	
	@Test
	public void Register_05_Incorrect_Password() {
		// Mo app ra
				driver.get("https://alada.vn/tai-khoan/dang-ky.html");
				
				// nhap lieu
				driver.findElement(By.id("txtFirstname")).sendKeys("Quan Tran");
				driver.findElement(By.id("txtEmail")).sendKeys("quantran@hotmail.com");
				driver.findElement(By.id("txtCEmail")).sendKeys("quantran@hotmail.com");
				driver.findElement(By.id("txtPassword")).sendKeys("1234567");
				driver.findElement(By.id("txtCPassword")).sendKeys("123456");
				driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
						
				//  click vao Dang ky button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
			
						
				// Kiem tra 1 dk tra ve la mong muon
				Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}
	
	@Test
	public void Register_06_Incorrect_Phone() {
		// Mo app ra
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		// nhap lieu
		driver.findElement(By.id("txtFirstname")).sendKeys("Quan Tran");
		driver.findElement(By.id("txtEmail")).sendKeys("quantran@hotmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("quantran@hotmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("987654321");
				
		//  click vao Dang ky button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
				
		// Kiem tra 1 dk tra ve la mong muon
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}