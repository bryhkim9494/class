package chapter04.exam;

public class Exam06 {
	public static void main(String[] args) {
		// while 문을 이용해서 1부터 99까지의 합을 구하는 프로그램을 작성

		int num = 1;
		int sum = 0; // 합의 초기화는 0으로 한다.

		while (num < 100) {
			// 반복 처리하는 문장: 합을 구하는 연산
			sum += num;
			num++;
		}

		sum = 0;
//		int i;
		for (int i = 1; i < 100; i++) { //여기서 선언된 i는 for문 안에서만 작동함 (i는 지역변수라고함)
			sum +=i; //while문에서는 i가 아니라 num이였음.
		}

		System.out.println("1~99까지의 합 : " + sum);
	}
}
