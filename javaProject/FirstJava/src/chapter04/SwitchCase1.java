package chapter04;

public class SwitchCase1 {
	public static void main(String[] args) {
		int score = 99;
		// 점수별 학점 체크 
		
		// score / 10
		// 100 ->10
		// 90 ~ 99 -> 9 90점 이상
		// 80 ~ 89 -> 8 80점 이상 90점 미만
		// 70 ~ 79 -> 7
		score =100;
		score = 75;
		score = 50;
		switch (score/10) {
		case 10:
//			System.out.println("A");
//			break;
		case 9 :
			System.out.println("A");
			break;
		case 8 :
			System.out.println("B");
			break;
		case 7 :
			System.out.println("C");
			break;
		case 6 :
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			break;
		}
		
		int key = 60;
//		key= 9;
//		key= 20;
//		key= 0;
		switch (key) {
		case 10: //key == 10
			System.out.println("10 입니다.");
			break;// 감싸고 있는 블록을 탈추
		case 20:
			System.out.println("20 입니다.");
			break;
		default:
			System.out.println("10 또는 20이 아닌 숫자 입니다.");
			break;
		}
	}
}
