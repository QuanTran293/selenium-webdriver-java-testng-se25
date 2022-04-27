package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Web_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void TC_01_Firefox() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}

	@Test
	public void TC_01_Define_Element() {
		// Muốn thao tác được với Element thì mình phải tìm element trước
		// Sau đó mới áp dụng hành vi vào cho Element đó
		
		// 1 - Tìm Element
		// 2 - Với loại Locator gì
		// 3- Tương tác lên/ Kiểm tra nó
		
		// Muốn thao tác trực tiesp lên element thì ko cần khai báo biến
		driver.findElement(By.id("send2")).click();
		
		// thao tác từ 2 lần trở lên thì cần khai báo biến tránh việc lặp lại
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("quan@gmail.com");
		driver.findElement(By.id("email")).isDisplayed();
		
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.clear();
		emailTextbox.sendKeys("quan@gmail.com");
		emailTextbox.isDisplayed();
	}
	
	@Test
	public void TC_02_Element_Method () {
		WebElement element = driver.findElement(By.id(""));
		
		// Xóa dữ liệu trong những field cho phép nhập
		// Luôn luôn clear dữ liệu trước khi thao tác lên field đó
		// Textbox/ TextArea/ Editable Dropdow
		element.clear();
		
		// nhập dữ liệu trong những field cho phép nhập
		element.sendKeys("");
		element.sendKeys(Keys.ENTER);
		
		// Element cha: findElement(By.className("footer"));
		// Element tiếp theo của con: findElement(By.cssSelector("a[title='My Account']"));
		driver.findElement(By.className("footer")).findElement(By.cssSelector("a[title='My Account']"));
		driver.findElement(By.xpath("//div[a@class='footer']//a[ơ@title='My Account']"));
		
		// Không khai báo biến = verify trực tiếp
		 Assert.assertEquals(driver.findElement(By.id("search")).getAttribute("placeholder"), "Search entire stop here...");
		 
		 // Khai báo biến để dùng nhiều lần
		 String searchTextboxPlaceholderValue = driver.findElement(By.id("search")).getAttribute("placeholder");
		 Assert.assertEquals(searchTextboxPlaceholderValue, "Search entire stop here...");
		 
		 
		 // GUI: Font/Size/Color/Pixel...
		 element.getCssValue("background-color");
		 // rgb(149, 246, 6)
		 element.getCssValue("font-size");
		 // 13px
		 
		 //GUI: Positio/ Location/ Size of element
		 element.getLocation();
		 element.getRect();
		 element.getSize();
		 
		 // Framework: Attach screenshot to report HTML
		 element.getScreenshotAs(OutputType.FILE);
		 
		 element = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']"));
		 element = driver.findElement(By.cssSelector("div[id='advice-validate-email-email']"));
		 
		 element = driver.findElement(By.cssSelector("#advice-validate-email-email"));
		 String emailTextboxTagname = element.getTagName();
		 
		 //output của element này là input của element khác
		 
		
		 // Truyền 1 biến vào trong 1 chuỗi
		 driver.findElement(By.xpath("//" + emailTextboxTagname + "[@id='advice-validate-email-email']"));
		 // Chuỗi thứ 1 + biến + chuỗi thứ 2
		 
		 // lấy ra Text của element hiện tại
		 /// Text của những element con bên trong
		 element.getText();
		 
		 // Mong muốn 1 element hiển thị/ không hiển thị
		 // Hiển thị: Người dùng nhìn thấy được/ có kích thước cụ thể (chiều rộng/cao)
		 // Áp dụng cho tất cả các loại Element: textbox/ textarea/ dropdown/ checkbox/ radio/ button/...
		 element.isDisplayed();
		 
		 // Mong muốn 1 element có thể thao tác được lên hoặc ko
		 // Ngược lại vs disable
		 // Tháo tác được: enable
		 // Không thao tác được: Disable
		 // Áp dụng cho tất cả các loại element: textbox/ textarea/ dropdown/ checkbox/ radio/ button/...
		 element.isEnabled();
		 
		 // click vào 1 element:
		 // Button/ linl/ checkbox/ radio/ image/ icon/...
		 element.click();


	}
	
	@AfterClass
	public void afterClass () {
		driver.quit();
	}
	
}