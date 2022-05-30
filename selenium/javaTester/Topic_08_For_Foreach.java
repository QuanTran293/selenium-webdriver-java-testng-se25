package javaTester;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
	WebDriver driver;
//	@Test
	public void TC_01_For_Iterate() {
//	for (int i = 0; i < 5; i++) {
//		System.out.println(i);

	
	// Ve 1: Bien tam dung de tang gia tri len sau moi lan duyet
	// Dung de so sanh vs tong gia tri
	// Ve 2: So sanh vs tong
	// Ve 3: Tang i len 1 don vi sau khi chay vao than vong for
	
	// Lan 1
	// i = 0
	// 0 < 5: dung
	// System.out.println(0)
	// i++: tang len 1 don vi (i =1)
	
	// Lan 2
		// i = 1
		// 1 < 5: dung
		// System.out.println(1)
		// i++: tang len 1 don vi (i =2)
	
	// Lan 3
			// i = 2
			// 2 < 5: dung
			// System.out.println(2)
			// i++: tang len 1 don vi (i =3)
	
	// Lan 4
				// i = 3
				// 3 < 5: dung
				// System.out.println(3)
				// i++: tang len 1 don vi (i = 4)
	
	// Lan 5
	// i = 4
	// 4 < 5: dung
	// System.out.println(4)
	// i++: tang len 1 don vi (i = 5)
	
	// Lan 6
		// i = 5
		// 5 < 5: sai
		// ==> ko chay vao than vong for
	
//	for (int i = 1; i <= 5; i++) {
//		System.out.println(i);
		
		// Lan 6
				// i = 5
				// 5 <= 5: dung
				// System.out.println(5)
				// i++: tang len 1 don vi (i = 6)
		
		// Lan 7
				// i = 6
				// 6 < 5: sai
				// ==> ko chay vao than vong for

		//List<WebElement> links = driver.findElements(By.id(""));
		// links.size();
		
		// Array
		String[] cityName = {"Hanoi", "HCM", "CT", "DN"};
		
		
		//Array/List/Set/Queue (index)
		// 0: nen bd tu 0
		
		// For ket hop vs if: thoa man dieu kien moi action
		for (int i = 0; i < cityName.length; i++) {
			if (cityName[i].equals("DN")) {
				//action
				System.out.println("Do action!");
				//break;
		}
	}
		// Dung de chay qua het tat ca gia tri
	//	for (String city : cityName) {
	//		System.out.println(city);
			
		
		int y = 0;
		for (String city : cityName) {
			if (cityName[y].equals("DN")) {
				System.out.println("Do action!");
				System.out.println(city);
				break;
		}
			y++;
		}	
}
//	@Test
	public void TC_02_For() {
		int i=1;
		for (i=0; ;) {
	System.out.println(i);
		}
	}
	
	@Test
	public void TC_03_Foreach() {
		// Dung cho Array hoac dung cho Collection
		String[] cityName = {"Hanoi", "HCM", "CT", "DN", "HP", "KH"};

		// Java collection
		// class: ArrayList/ LinkedList/ Vector/...
		// interface: List/ Set/ Queue
		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress.size());
		
		// Compile (Coding)
		cityAddress.add("Bac Giang");
		cityAddress.add("Ha Giang");
		cityAddress.add("Sapa Giang");
		System.out.println(cityAddress.size());
		
		// Runtime (Running)
		for (String city : cityName) {
			cityAddress.add(city);	
		}
		
		System.out.println(cityAddress.size());
	
		for (String cityAdd : cityAddress) {
			System.out.println(cityAddress);
		}
	
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		// Xu ly du lieu/ get text/ value / css / attribute
		for (WebElement link : links) {
		
			// Chuyen page
			// refresh lai DOM/ HTML
			// ko con ton tai
			// van tiep tuc chay for va se bi FAIL=> StableElementException
			
		}
		
	}

}




















