package javaTester;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Topic_01_Data_Type {

	public static	void main(String[] args) {
		// khai báo biến : Kiểu dữ liệu + tên biến
		int studentNumber;
		
		// Khởi tạo dữ liệu
		studentNumber = 100;
		
		// Khai báo + khởi tạo
		int teacherNumber = 20;
		
		// I - Nguyên thủy (Primitive)
		
		// boolean
		boolean studentSex = true;
		
		// byte
		byte bEmployee = 100;
		
		//short
		short sEmployee = 10;
		
		// int
		int iEmployee = 10;
		
		// long
		long lEmployee = 10000;
		
		// float
		float fEmployee = 7.5f;
		
		// double
		double dEmployee = 8.4d;
		
		// char: 1 kí tự
		// char: a = 'B';
		
		// II - Tham chiếu ( Reference)
		// Array
		int[] studentNumbers = {15, 50, -7, 19};
		String[] studentName = {"Nguyễn Văn Nam", "Ngô Văn Tới"};
		
		// Interface/Class
		// WebDriver driver = new ChromeDriver ();
		
		// Actions action = new Actions (driver);
		
		// Collection: List (ArrayList/ LinkedList)/ Set/ Queue
		// ArrayList<String> studentCountry = new ArrayList<String>();
		
		// Object
		Object phone;
		
		// String: Số/ Chữ/ kí tự đặc biệt
		String a = "Hoang";
		System.out.println(a);
		
		String b = a;
		System.out.println(a);
		System.out.println(b);
		
		b = "An";
		a = b;
		System.out.println(a);
		System.out.println(b);
		
		//By emailTextboxby = By.cssSelector("");
		//WebElement emailTextbox = driver.findElement(By.cssSelector(""));
		
		//List<Element> checkboxes = driver.findElement(By.cssSelector(""));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
	}	
	}		