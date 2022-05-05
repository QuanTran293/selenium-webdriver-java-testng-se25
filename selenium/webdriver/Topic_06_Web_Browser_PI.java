package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Browser_PI {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void TC_01_Firefox() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}

	@Test
	public void TC_01_Method() {
		// dùng để close browser/tab
		// nếu như chỉ có 1 tab -> close browser
		// nếu như nhiều hơn 1 tab: close tab active
		driver.close();
		
		// dùng để ĐÓNG browser ko quan tâm có bn tab
		driver.quit();
		
		// MỞ 1 URL ra
		driver.get("http://live/techpanda.org/");
		
		// Bài WAIT
		// dùng để tìm 1 ELEMENT
		driver.findElement(By.xpath(""));
		
		// dùng để tìm nhiều ELEMENTS
		driver.findElements(By.xpath(""));
		
		// lấy ra url của Page HIỆN TẠI
		driver.getCurrentUrl();
		
		// lấy ra SOURCE CODE của page hiện tâij
		driver.getPageSource();
		
		// lấy ra TITLE của page hiện tại
		driver.getTitle();
		
		// Bài WINDOWS / TAB handle
		// dùng để xử lí WINDOW / TAB
		// lấy ra ID của TAB đang active
		driver.getWindowHandle();
		
		
		// lấy ra ID của tất cả các TAB/ WINDOW đang có
		driver.getWindowHandles();
		
		// cookie: lưu lại phiên đăng nhập
		driver.manage().deleteAllCookies();
		
		// Framework
		// driver.manage().logs().get(Log);
		
		// chờ cho findElement
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		// chờ cho page load thành công
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		// chờ cho 1 đoạn code JavaScript được thực thi thành công
		// Bài JavaScript Executor
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		// full hết màn hình
		driver.manage().window().fullscreen();
		
		// mở rộng hết cửa sổ
		driver.manage().window().maximize();
		
		// thực tế ko dùng: Test GUI/ Responsive (Font/Size/Color/Position/Location/..)
		driver.manage().window().setPosition( new Point(100, 250));
		// Set vị trí của browser so vs độ phân giải màn hình ( Resolution)
		driver.manage().window().getSize();
		
		
		// mở browser vs cái kích thước là bao nhiêu
		// Test responsive
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().window().getSize();
		
		// tracking history tốt hơn
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("https://www.facebook.com/");
		
		// alert
		driver.switchTo().alert();
		
		// frame/Iframe
		driver.switchTo().frame(0);
		
		// Windos/ Tab
		driver.switchTo().window("");
		
		
		
		
		

	}
	
	@AfterClass
	public void afterClass () {
		driver.quit();
	}
	
}