package javaTester;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_Do_While {
	Scanner scanner = new Scanner(System.in);
	
	
//	public void main(String[] args) {
//		TC_01_For();
//		TC_02_While();
//		TC_03_Do_While();
//		TC_04_While();
		
		
//		int i = 0;
		
//		for (i = 0; i < 5; i++) {
//		System.out.println("For: " + i);
		
//		if(i==3) {
//			break;
//		}
//		}
	
//		int i = 0;
//		while (i < 5) {
//		System.out.println("while: " + i);
//		i++;
		
//		if(i==3) {
//			break;
//		}
//		}
		
		// chay it nhat 1 lan moi kiem tra dieu kien
//		do {
//			System.out.println("Do-While: " + i);
//			i++;
//		} while (i < 5);
//	@Test
	public void TC_01_For() {	
		int number = scanner.nextInt();
		for (int i = number; i < 100; i++) {
			if (i%2 == 0) {
				System.out.println(i);
			}
		}
	}
//		@Test
		public void TC_02_While() {	
			int number = scanner.nextInt();
			while (number < 100) {
				if (number%2 ==0) {
			System.out.println(number);
			number++;
}
}
		}
//	@Test
	public void TC_03_Do_While() {	
				int number = scanner.nextInt();
				do {
					if (number%2 ==0) {
						System.out.println(number);
						number++;
					}
				} while (number < 100);
					}
//	@Test
	public void TC_04_While() {	
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		while (numberA < numberB) {
			if (numberA % 3 == 0 && numberA % 5 == 0) {
				System.out.println(numberA);
			}
				numberA++;
			} 
	}
//	@Test
	public void TC_05_While() {	
		int numberC= scanner.nextInt();
		int i = 0;
		
		while(numberC > 0) {
			if(numberC % 2 !=0) {
				System.out.println(numberC);
				i += numberC;
			}
			numberC--;
		}
		System.out.println(i);			
	}
	@Test
	public void TC_06_While() {	
		int numberD= scanner.nextInt();
		int i = 1;
		
		while(numberD > 0) {
			i *= numberD;
			numberD--;
		
	}	
		System.out.println(i);
}	
}
 















