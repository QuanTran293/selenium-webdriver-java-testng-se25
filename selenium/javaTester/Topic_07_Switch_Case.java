package javaTester;

import org.testng.annotations.Test;
import java.sql.Driver;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.beust.jcommander.Parameters;

public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
//	@Test
	public void TC_01() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Thang nay co 31 ngay");
			break;
		
		case 2:
			System.out.println("Thang nay co 28 ngay");
			break;	
		
		case 4:	
		case 6:	
		case 9:	
		case 11:
			System.out.println("Thang nay co 30 ngay");
			break;
			
		default:	
			System.out.println("Thang vua nhap sai dinh dang");
			break;
		}
	}
//	@Test
	public void TC_02() {
		int alphabet = scanner.nextInt();
		switch (alphabet) {
		case 1:
			System.out.println("one");
			break;
		case 3:
			System.out.println("three");
			break;
		case 5:
			System.out.println("five");
			break;
		case 7:
			System.out.println("seven");
			break;
		case 8:
			System.out.println("eight");
			break;
		case 10:
			System.out.println("ten");
			break;
		case 12:
			System.out.println("twelve");
			break;
		case 2:
			System.out.println("two");
			break;			
		case 4:	
			System.out.println("four");
			break;
		case 6:	
			System.out.println("six");
			break;
		case 9:	
			System.out.println("nice");
			break;
		case 11:
			System.out.println("eleven");
			break;
			
		default:	
			System.out.println("vui long nhap tu 1-12");
			break;
	}
	}

		@Test
		public void TC_03() {
			String operator = scanner.nextLine();
			int firstnumber = scanner.nextInt();
			int secondnumber = scanner.nextInt();
			
			//hoac
			
			//int firstnumber = scanner.nextInt();
			//int secondnumber = scanner.nextInt();
			//String operator = scanner.next//String operator = scanner.nextLine();();
			
			
			switch (operator) {
			case "+":
				System.out.println("A+B=" + (firstnumber + secondnumber));
				break;
			case "-":
				System.out.println("A-B=" + (firstnumber - secondnumber));
				break;
			case "+*":
				System.out.println("A*B=" + (firstnumber * secondnumber));
				break;
			case "/":
				System.out.println("A/B=" + (firstnumber / secondnumber));
				break;
			case "%":
				System.out.println("A%B=" + (firstnumber % secondnumber));
				break;	
			}
		
		

		
		
		}
}


