package javaTester;

import org.testng.annotations.Test;

public class Topic_05_Primitive_Casting {

	@Test
	public static void main(String[] args) {
		//ngam dinh = ko mat du lieu
		// byte
	//	byte bNumber = 100;
	//	System.out.println(bNumber);
		
		//short
	//	short sNumber = bNumber;
	//	System.out.println(sNumber);
		
		// int
	//	int iNumber = sNumber;
	//	System.out.println(iNumber);
		
		// long
	//	long lNumber = iNumber;
	//	System.out.println(lNumber);
		
		// float
	//	float fNumber = lNumber;
	//	System.out.println(fNumber);
		
		// double
	//	double dNumber = fNumber;
	//	System.out.println(dNumber);
		
		
		// Tuong minh
		double dNumber = 654321789;
		System.out.println(dNumber);
		
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		
		long lNumber = (long) fNumber;
		System.out.println(lNumber);
		
		int iNumber = (int) lNumber;
		System.out.println(iNumber);
	}
	
}
