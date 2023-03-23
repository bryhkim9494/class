package quiz;

public class Quiz05 {
	public static void main(String[] args) {
		int num = -100;
		
		
		
		switch (num/100) {
		
		case 10:
			
		case 3:
			System.out.println("300이상");
			break;
		case 2:
			System.out.println("200이상 300미만");break;
		case 1:
			System.out.println("100이상 200미만");break;
		case 0:
			System.out.println("0이상 100미만");break;
		default:
			break;
		}
		
		if (num < 0) {
			System.out.println("0미만");
		}
	}
}
