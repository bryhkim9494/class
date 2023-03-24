package chapter04.exam;

public class Exam08 {
	public static void main(String[] args) {
//		문제 8.
//
//		1000 이하의 자연수 중에서 : 1~ 1000 -> 반복문을 사용해서 1~1000까지 숫자 확인
//		2의 배수 이면서 7의 배수인 숫자를 -> 찾고 싶은 숫자의 조건 (num%2==0 ,&&, num%7 ==0)
//		출력하고, 
//		그 출력된 숫자들의 합을 구하는 : sum = sum + num; (합 구하는 공식)
//		프로그램을 while 문을 이용해서 작성
		int num = 1;
		int sum = 0;
		while (num <= 1000) {

			if (num % 2 == 0 && num % 7 == 0) {
//				System.out.println(num);
				sum += num;
			}
//			System.out.println(num);
			num++;
		}
		System.out.println("1000이하의 자연수중 2의배수이면서 7의배수들의합 : " + sum);
	}
}
