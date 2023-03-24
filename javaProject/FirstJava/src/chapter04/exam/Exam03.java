package chapter04.exam;

public class Exam03 {
	public static void main(String[] args) { //문제3. CondOp.java를 조건연산자(3항 연산자)를 사용하지 않고, if~else를 사용하는 형태로 변경해 보자.
		// 두 수의 큰수를 찾아 출력하고 두수의 차를 출력하자.

		// 복습할때 스캐너 사용해서 해보기
		int num1 = 150;
		int num2 = 100;
		int big = 0; // 큰수를 저장
		int diff = 0; // 두수의 차이값을 저장

//		큰 수 -> 두수를 비교해서 판별
//		big = (num1 > num2)? num1:num2; if구문 보다 삼항 연산자가 가독성이 좋음
		if (num1 > num2) {
			big = num1;
			
		}else {
			big = num2;
			
		}
			
		
		
		
//		 두수의 차 -> 두수의 큰수와 작은수를 구해서 큰수에서 작은수르 빼준다!
//		
//		 diff = (num1 >num2)? num1-num2:num2-num1;
		if (num1 > num2) {
			diff = num1- num2;
		} else {
			diff = num2 - num1;
		}
		
		System.out.println("큰 수 : " + big);
		System.out.println("두수의 차 : " + diff);
		
		
		
		
		
		
		
		
		

	}
}
