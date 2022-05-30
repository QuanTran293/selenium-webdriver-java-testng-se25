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

public class Topic_06_Exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
//	@Test
	public void TC_01() {
		
		int number = scanner.nextInt();
		
		
		if (number % 2 ==0) {
			System.out.println("So: " + " la so chan");	
		} else {
			System.out.println("So: " + " la so le");	
		}
		
	}
//	@Test
	public void TC_02() {	
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		if (numberA >= numberB) {
		System.out.println(numberA + " Lon hon hoac bang " + numberB);
		
		} else {
		
			System.out.println(numberA + " nho hon " + numberB);
	
		}		
		
	}		
//	@Test
	public void TC_03() {	
	String firstStudent = scanner.nextLine();
	String secondStudent = scanner.nextLine();
	
	// Reference: String
	// Kiểm tra cái value của biến
	// Kiểm tra vị trí của biến trong vùng nhớ
	if (firstStudent.equals(secondStudent)) {
		System.out.println("2 sv giong ten nhau");
	} else {
		System.out.println("2 sv khac ten nhau");
	}
	
	if (firstStudent == secondStudent) {
		System.out.println("2 sv giong ten nhau");
	} else {
		System.out.println("2 sv khac ten nhau");
	// == thuong dung vs so
	// == dua text de bi sai > khác nhau trong vùng nhớ
	}	
	}
//	@Test
	public void TC_04() {	
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
	
		if (numberA > numberB && numberA > numberC) {
			System.out.println(numberA + " la so lon nhat " );
			
			} else if(numberB > numberC) {
			
				System.out.println(numberB + " la so lon nhat " );
				
			} else {
				
				System.out.println(numberC + " la so lon nhat " );	
		
			}	
	}
//	@Test
	public void TC_05() {	
		int numberA = scanner.nextInt();
		
		if (10 < numberA && numberA <100) {
			System.out.println(numberA + " nam trong khoang (10-100)");
		} else {
			System.out.println(numberA + " nam ngoafi khoang (10-100)");
	
		}
	}

		
//		@Test
		public void TC_06() {	
			float studentPoint = scanner.nextFloat();
			
			if (studentPoint <= 10 && studentPoint >= 8.5) {
				System.out.println("He so A");
			} else if (studentPoint < 8.5 && studentPoint > 7.5) {
				System.out.println("He so B");
			} else if (studentPoint < 7.5 && studentPoint >= 5) {
				System.out.println("He so C");
			} else {
				System.out.println("He so D");
			}	
		
	}
		@Test
		public void TC_07() {	
			int month = scanner.nextInt();
			
			if (month==1 || month==3 || month==7 || month==8 || month==10 || month==12) {
				System.out.println("Thang nay co 31 ngay");
			
			} else if (month==2) {
				
				System.out.println("thang nay co 28/29 ngay");
				
			} else {
				System.out.println("thang nay co 30 ngay");
			
			
			}
		}
}
















