package javaTester;

import org.testng.annotations.Test;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
//	@Test
	public void TC_01_If() {
		
	}
	public static void main(String[] args) {
		boolean status = 5 < 3;
		System.out.println(status);
		
		// ham if se nhan vao 1 dieu kien dung
		// Kiem tra duy nhat 1 dieu kien
		// neu dieu kien nay dung thi se action (xxx) trong phan than
		if (status) {
			// dung thi va phan than cua if
			// neu sai thi bo qua
			System.out.println("go to if");
		}
		
		WebDriver driver = new FirefoxDriver();
		
		// Element luoon luoon co torng DOM du popup hien thi hay ko 
		WebElement salePopup = driver.findElement(By.id(""));
		
		if (salePopup.isDisplayed()) {
		
		}
		// Element ko co trong DOM khi popup ko hien thi
		List<WebElement> salePopups = driver.findElements(By.id(""));
		
		// Chac element ko hien thi
		if (salePopups.size()>0 && salePopups.get(0).isDisplayed()); 		
		}


		// uncheck to checkbox
		//WebElement languagesCheckbox = driver.findElement(By.id(""));
		//if (languagesCheckbox.isSelected()) {
		//	languagesCheckbox.click();
		//}
		
		// check to checkbox
		//if (!languagesCheckbox.isSelected()) {
		//	languagesCheckbox.click();


//	@Test
	public void TC_02_If_Else() {
		// cos toi 2 dieu kien: neu dung thi vao if - sai thi vao else
		
		
		// neu driver start vs cac trinh duyet nhu chrome/ firefox/ safari/edge thi dung ham click
		// thong thuong builtin cua Selenium WebDriver
		
		//Neu driver la IE thi dung ham click cua JavascriptExecutor
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		if (driver.toString().contains("firefox")) {
			System.out.println("Click by Javascript Executor");
		} else {
			System.out.println("Click by Selenium WebElement");
		}
	}
		
	@org.testng.annotations.Parameters ("browser")
	@Test
		public void TC_03_If_Else_If_Else(String browsweName) {	
		//if (browsweName.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	//} else if (browsweName.equalsIgnoreCase("chrome")) {
	//	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	//	driver = new ChromeDriver();
	
	
	//} else {
		
	//	throw new RuntimeException("Please input abc xyz");
	
	//}
	}
		@Test
		public void TC_04_If_Else_If_Else1() {	
			// Page Object
			// Dynamic page
			
			String pageName = "Login";
			if (pageName.equals("Login")) {
				//LoginPage loginPage = new LoginPage();
				// return loginPage;
			} else if (pageName.equals("Register")) {
				//Register registerPage = new Register();
				// return registerPage;

			} else {
				//HomePage homePage = new HomePage();
				// return homePage;
			}
			
			// if-else viet gon hon
			int age = 20;
			String access = (age < 18) ? "You can not access" : "Welcome to our system!";

		if (age < 18) {
			access = "You can not access";
			
		} else {
			access = "Welcome to our system!";
		}
		System.out.println(access);
			
			
		
		}
}




















