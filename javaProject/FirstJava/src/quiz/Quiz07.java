package quiz;

public class Quiz07 {
	public static void main(String[] args) {
		int num = 1;
		while(num <101) {
			System.out.println(num);
			num++;
		}
		
		System.out.println();
		num = 100;
		while (num>0) {
			System.out.println(num);
			num--;
		}
		int num2 = 1;
		
		System.out.println();
		do {
			System.out.println(num2);
			num2++;
		} while (num2 < 101);
		
		System.out.println();
		num2 =100;
		do {
			System.out.println(num2);
			num2--;
			
		} while (num2 > 0);
		
	}
}
