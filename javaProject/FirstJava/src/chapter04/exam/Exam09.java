package chapter04.exam;

public class Exam09 {
	public static void main(String[] args) {
//		문제 9.
//
//		for 문을 이용하여 1부터 10까지를 곱해서 그 결과를 출력하는 프로그램을 작성
		int result = 1; // 곱할때는 0으로 초기화X 
		for (int i =1;i<=10;i++) {
//			System.out.println(i);
			result = result*i;
			//System.out.println("1~10까지의 숫자들의 곱한 결과 : " + result);
			}
		System.out.println("1~10까지의 숫자들의 곱한 결과 : " + result);
		}
		
		
		
	
}
