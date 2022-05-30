package javaTester;

public class Topic_10_Break_Continue {
	public static void main(String[] args) {
		// nested for
		for (int i = 1; i < 5; i++) {		
			System.out.println("Lan chay cua i ( for 1st) =" + i);
			// i = 1
			// moi 1 lan chay cua for tren se apply cho tat ca cac lan chay cua for duoi nay
			for (int j = 1; j <=5; j++) {
				if (j==4) {
					continue;
				
			}
			System.out.println("Lan chay cua j ( for 2nd) =" + j);
			
			for (int x = 1; x <=5; x++) {
				if (x==4) {
					continue;
				
			}
			System.out.println("x =" + x);
			}
			// j = 1
			// j = 2
			// j = 3
			// j = 5
	}
}
}
}