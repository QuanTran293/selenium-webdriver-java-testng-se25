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

public class Topic_12_Random_Popup {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01_NgoaiNgu24h() {
	driver.get("https://vnk.edu.vn/");
	sleepInSecond(15);
	
	// luon co elemen trong DOM du co hien thi hay ko
	
	if(driver.findElement(By.xpath("//div[@id=\"tve_editor\"]")).isDisplayed()) {
		System.out.println("Neu nhu popup hien thi thi thao tac vs popup r close no di - sau do lam cac tep tiep theo");
		driver.findElement(By.cssSelector("div.thrv_icon")).click();

	   
	   //expected popup ko con hieu ti
	   Assert.assertFalse(driver.findElement(By.xpath("//div[@id=\"tve_editor\"]")).isDisplayed());
	} else {
		
		System.out.println("Neu nhu popup ko hien thi thi qua step tiep theo luon-passed");
	}
	// Neu nhu popup hien thi thi thao tac vs popup r close no di - sau do lam cac tep tiep theo
	// Neu nhu popup ko hien thi thi qua step tiep theo luon
	
	
	// click vao trang lien he
	driver.findElement(By.xpath("//a[@title=\"Liên hệ\"]")).click();
	
	// verify qua trang lien he thanh cong
	Assert.assertEquals(driver.getCurrentUrl(), "https://vnk.edu.vn/lien-he/");
	//Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"title-content\"]")).isDisplayed());
	
	}	
	@Test
	public void TC_02_Random_In_Dom_KmPlayer() {
		driver.get("https://www.kmplayer.com/home");
		sleepInSecond(2);
		
		if(driver.findElement(By.xpath("//div[@id=\"layer2\"]")).isDisplayed()) {
			System.out.println("Neu nhu popup hien thi thi thao tac vs popup r close no di - sau do lam cac tep tiep theo");
		
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("area#btn-r")));
			
			sleepInSecond(2);
		
		Assert.assertFalse(driver.findElement(By.xpath("//div[@id=\"layer2\"]")).isDisplayed());
		
		} else {
			
		System.out.println("Neu nhu popup ko hien thi thi qua step tiep theo luon-passed");	
		}
	
	driver.findElement(By.xpath("//a[text()='MOVIEBLOC ']")).click();
	sleepInSecond(3);
	Assert.assertEquals(driver.getCurrentUrl(), "https://www.moviebloc.com/?r=kmplayer&kind=hp");
	
	}	
	
	@Test
	public void TC_03_DeHieu() {
		driver.get("https://dehieu.vn/");
		sleepInSecond(2);
		
		if(driver.findElement(By.xpath("//div[@class='popup-content']")).isDisplayed()) {
		
			driver.findElement(By.cssSelector("input#popup-name")).sendKeys("John Quick");
			driver.findElement(By.cssSelector("input#popup-email")).sendKeys("JohnQuick@gmail.net");
			driver.findElement(By.cssSelector("input#popup-phone")).sendKeys("0908985326");		
			sleepInSecond(2);
			
		driver.findElement(By.xpath("//button[@id=\"close-popup\"]")).click();
		
		// ko dung cach nay de verify popup ko hien thi nua
		// li do: khi no ko hien thien nua (close r) thi element ko con trong DOM
		// ko con trong DOM thi ko findelement dc
		// findElement should not be used to look for non-present elements
		// NoSuchElementException - if no matching elements are found
	
		
		driver.findElement(By.xpath("//a[text()=\"Tất cả khóa học\"]")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(), "https://dehieu.vn/khoa-hoc");
		
		 
		}
	}
	@Test
	public void TC_04_Drag_And_Drop_HMTL5_Css() {
	
	
	
		
	}	
	
	public void TC_05_Drag_And_Drop_HMTL5_Xpath() {
	
		
		
		
		
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