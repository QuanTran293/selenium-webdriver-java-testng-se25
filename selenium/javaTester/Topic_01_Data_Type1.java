package javaTester;

import java.util.Scanner;

public class Topic_01_Data_Type1 {
	
	public Topic_01_Data_Type1() {
		String studentName;
	}
	
	static int studentNumber;
	static boolean statusValue;
	static final String browserName ="Chrome";
	static int studentPrice;
	
	protected String studentName = "Automation FC";
	
	public static void main (String[] args) {
		int studentPrice = 5;
		
		System.out.println(studentNumber);
		System.out.println(statusValue);
		System.out.println(Topic_01_Data_Type1.browserName);
	
		Topic_01_Data_Type1 topic_1 = new Topic_01_Data_Type1();
		Topic_01_Data_Type1 topic_2 = new Topic_01_Data_Type1();
		Topic_01_Data_Type1 topic_3 = new Topic_01_Data_Type1();
	
		System.out.println(topic_1.studentName);
		System.out.println(topic_2.studentName);
		System.out.println(topic_3.studentName);
	
	// BROWSER_NAME ="";
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.print(name);
	
	
	}
		
	// Getter: getCurrentUrl/ getTitle/ getText/ getAttribute/ getCssValue/...
	public String getStudentName() {
		return this.getStudentName();
	}
	
	// Setter: click/ sendkey/ clear/ select/ back/ forward/ refresh/ get/...
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
	}	
