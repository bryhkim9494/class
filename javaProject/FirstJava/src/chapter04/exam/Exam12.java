package chapter04.exam;

public class Exam12 {
	public static void main(String[] args) {
//		문제 12.
//
//		자연수 1부터 시작해서 
//		모든 홀수와 3의 배수인 짝수를 
//		더해 나간다. 
//		그리고 그 합이 언제 (몇을 더했을 때) 1000이 넘어서는지, 
//		그리고 1000이 넘어선 값은 얼마가 되는지 계산하여 출력하는 프로그램을 작성.
		int num = 1;
		int sum = 0;
		while (true) {
//			모든 홀수와(또는 이거나) 3의 배수인(이면서) 짝수를 찾는다

			if (num % 2 == 1 || (num % 3 == 0 && num % 2 == 0)) {
				sum += num;
				System.out.println(sum);
			}

//			if(num % 2 == 1) {
//				sum +=num;
//			} else if (num %3==0) {
//				sum +=num;
//			}
			if (sum > 1000) {
				System.out.println(num + "값을 더했을때 1000이 넘어갑니다.");
				System.out.println("최초로 1000이 넘어간 숫자 : " + sum);
				break;
			}
			num++;

		}

	}
}
