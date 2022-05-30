package javaTester;

import org.testng.annotations.Test;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;


public class Topic_04_Exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
//	@Test
	public void swapNumber() {
		int a = 3;
		int b = 4;
		
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a);	
		System.out.println(b);	
	}
	

//	@Test
	public void swapNumber1() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		if (a > b) {
			System.out.println("True");	
		} else {
			System.out.println("False");	
		}
	}
	@Test
	public void swapNumber2() {
		String name = scanner.next();
		int P1 = scanner.nextInt();
		int P2 = P1 + 15;
		
		System.out.println("After 15 years, age of Tuan will be" + " " +P2);
	
		}
	
	}

