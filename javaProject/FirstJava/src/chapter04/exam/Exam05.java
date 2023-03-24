package chapter04.exam;

public class Exam05 { // if문을 case문으로 바꾸는 예제
	public static void main(String[] args) {

		int num = 500;
		
//		num < 0 이라면 “0 미만” 출력 부분은 if문을 사용하고
		if (num < 0) {

			System.out.println("0미만");
		} else {
			switch (num / 100) {
			case 0: // case 0은 범위가 0~99라는 뜻이다.
				System.out.println("0이상 100 미만"); // 0이상인 이유는 if (num <0)이라는 조건때문이다.
				break;
			case 1:// 100~199
				System.out.println("100이상 200미만");
				break;
			case 2: // 200~299
				System.out.println("200이상 300미만");
				break;
			default:
				System.out.println("300이상");

			}

		}
	}
}
