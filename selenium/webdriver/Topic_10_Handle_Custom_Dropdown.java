package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Handle_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// luôn khởi tạo sau Driver => nó cần giá trị driver để khởi tạo
		// wait cho các element theo đk có sẵn: visible/ invisible/ presence/ clickable/...
		explicitWait = new WebDriverWait(driver, 15);
		
		// ep tuong minh
		jsExecutor = (JavascriptExecutor) driver;
		
		// wait cho việc tìm element: findElement/ findElements
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	}

//	@Test
	public void TC_01_Jqerry() {
		
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		/* chọn item 10 */
		selecItemCustomDropdown("span#number-button", "ul#number-menu>li>div", "10");
		
		//Verify da chon item 10
		Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "10");
		
		
		/* chọn item 5 */
		selecItemCustomDropdown("span#number-button", "ul#number-menu>li>div", "19");
		
		// Item này sẽ đổ dữ liệu vào dropdown này => verify chọn thành công
	}
	
	// truyền qua tham số
	public void selecItemCustomDropdown(String parentLocator, String childLocator,String expectedTextItem) {
		// Click vào dropdown cho xổ hết tất cả item bên trong ra ==> click
		driver.findElement(By.cssSelector(parentLocator)).click();
		sleepInSecond (1);
		
		// Chờ cho tất cả các item bên trong được load ra => WebDriverWait
		// By locator = đại diện cho " tất cả các item bên trong"
		// Phải lấy locator đến thẻ chứa text item
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		
		// Tìm item mong muốn (nếu như ko hiển thị thì cần cuộn chuột xuống để tìm) => vòng lặ để lấy
		// duyệt qua - getText từng cái
		// Thấy item cần chọn thì click vào => So sánh vs item mong muốn sau đó click vào
		
		// Khai báo từng element thì rất là nhiều/ tổng cộng bao nhiêu cái/ code nhiều
		// Lấy hết tất cả các item ra lưu vào 1 List WebElement
		List<WebElement> allDropdownItems = driver.findElements(By.cssSelector(childLocator));
		// 19 item trong này 
		
		// Duyệt qua gọn: vòng lặp
		for (WebElement item : allDropdownItems) {
			String actualTextItem = item.getText();
			
			// thấy item cần chọn thì click vào => so sánh vs item mong muốn sau đó click vào
			if(actualTextItem.equals(expectedTextItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond (2);
				
				item.click();
				sleepInSecond (1);
				// chưa thoát ra khỏi vòng lắp (6-19)
				break;
			}
		}
		// "span#number-button"
		// "ul#number-menu>li>div"
		
		
	}

//	@Test
	public void TC_02_react() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
	
		selecItemCustomDropdowna("i.dropdown", "div.item>span", "Jenny Hess");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Jenny Hess");
		
		selecItemCustomDropdowna("i.dropdown", "div.item>span", "Justen Kitsune");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Justen Kitsune");
		
		selecItemCustomDropdowna("i.dropdown", "div.item>span", "Jenny Hess");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Jenny Hess");
		
		
	}
		public void selecItemCustomDropdowna(String parentLocator, String childLocator,String expectedTextItem) {
			driver.findElement(By.cssSelector(parentLocator)).click();
			sleepInSecond (1);
			
		
			explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
			
			
			List<WebElement> allDropdownItems = driver.findElements(By.cssSelector(childLocator));
			
			for (WebElement item : allDropdownItems) {
				String actualTextItem = item.getText();
				
				// thấy item cần chọn thì click vào => so sánh vs item mong muốn sau đó click vào
				if(actualTextItem.equals(expectedTextItem)) {
					
					item.click();
					sleepInSecond (1);
					// chưa thoát ra khỏi vòng lắp (6-19)
					break;
	
	
				}
	
			}
	
	}

//	@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		selecItemCustomDropdownb("li.dropdown-toggle", "ul.dropdown-menu>li>a", "Second Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
		
		selecItemCustomDropdownb("li.dropdown-toggle", "ul.dropdown-menu>li>a", "First Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");
		
		selecItemCustomDropdownb("li.dropdown-toggle", "ul.dropdown-menu>li>a", "Third Option");
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
		
	}
		public void selecItemCustomDropdownb(String parentLocator, String childLocator,String expectedTextItem) {
			driver.findElement(By.cssSelector(parentLocator)).click();
			sleepInSecond (1);
			
		
			explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
			
			
			List<WebElement> allDropdownItems = driver.findElements(By.cssSelector(childLocator));
			
			for (WebElement item : allDropdownItems) {
				String actualTextItem = item.getText();
				

				if(actualTextItem.equals(expectedTextItem)) {
					
					item.click();
					sleepInSecond (1);
					break;
	
				}
	
			}
	}

//	@Test
	public void TC_04_nopcommerce() {
		driver.get("https://demo.nopcommerce.com/register");
		
		selecItemCustomDropdownc("select[name='DateOfBirthDay']", "select[name='DateOfBirthDay']>option", "10");
		Assert.assertTrue(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[text()='10']")).isSelected());
		
		selecItemCustomDropdownc("select[name='DateOfBirthDay']", "select[name='DateOfBirthDay']>option", "15");
		Assert.assertTrue(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[text()='15']")).isSelected());
		
	}
		public void selecItemCustomDropdownc(String parentLocator, String childLocator,String expectedTextItem) {
			driver.findElement(By.cssSelector(parentLocator)).click();
			sleepInSecond (1);
			
		
			explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
			
			
			List<WebElement> allDropdownItems = driver.findElements(By.cssSelector(childLocator));
			
			for (WebElement item : allDropdownItems) {
				String actualTextItem = item.getText();
				

				if(actualTextItem.equals(expectedTextItem)) {
					
					item.click();
					sleepInSecond (1);
					break;
	
				}
			}
			}
		
	@Test
	public void TC_05_Editable() {
driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		
		enterselecItemCustomDropdown("input.search", "div.item>span", "Bahamas");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Bahamas");
		
		enterselecItemCustomDropdown("input.search", "div.item>span", "Algeria");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Algeria");
		
		enterselecItemCustomDropdown("input.search", "div.item>span", "Benin");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Benin");
		
	}
		public void enterselecItemCustomDropdown(String editableLocator, String childLocator,String expectedTextItem) {
			driver.findElement(By.cssSelector(editableLocator)).sendKeys(expectedTextItem);
			sleepInSecond (1);
			
		
			explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
			List<WebElement> allDropdownItems = driver.findElements(By.cssSelector(childLocator));
			
			for (WebElement item : allDropdownItems) {
				String actualTextItem = item.getText();
				

				if(actualTextItem.equals(expectedTextItem)) {
					
					item.click();
					sleepInSecond (1);
					break;
	
				}
			}
			
		
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