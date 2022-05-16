package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// luôn khởi tạo sau Driver => nó cần giá trị driver để khởi tạo
		// wait cho các element theo đk có sẵn: visible/ invisible/ presence/ clickable/...
		explicitWait = new WebDriverWait(driver, 15);
		
		// wait cho việc tìm element: findElement/ findElements
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	}

	@Test
	public void TC_01_Jqerry() {
		
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		/* chọn item 10 */
		selecItemCustomDropdown("span#number-button", "ul#number-menu>li>div", "10");
		
		/* chọn item 5 */
		selecItemCustomDropdown("span#number-button", "ul#number-menu>li>div", "5");
		
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
				item.click();
				sleepInSecond (1);
				// chưa thoát ra khỏi vòng lắp (6-19)
				break;
			}
		}
		// "span#number-button"
		// "ul#number-menu>li>div"
		
		
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