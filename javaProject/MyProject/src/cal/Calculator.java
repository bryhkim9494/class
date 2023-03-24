package cal;

import java.util.Scanner;

public class Calculator {

//	public static void plus(int a, int b) {
//
//		System.out.println("더하기 : " + (a + b));
//	}
//
//	public static void minus(int a, int b) {
//		System.out.println("빼기 : " + (a - b));
//	}
//
//	public static void multiple(int a, int b) {
//		System.out.println("곱하기 : " + a * b);
//	}
//
//	public static void divide(int a, int b) {
//		System.out.println("나누기 : " + a / b);
//	}

	public static void main(String[] args) {
//		plus(3, 4);
//		minus(4, 3);
//		multiple(5, 4);
//		divide(6, 3);
//		add(20, 10);
//		sub(40, 10);
//		mul(5,4);
//		div(6,4);
//		System.out.println("원의 둘레 : " + cal1(4));
//		System.out.println("원의 넓이 : " + cal2(4));
		
		
		
		
		Scanner in = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요. >> ");
		long num1 = in.nextLong();
		System.out.print("두번째 숫자를 입력하세요. >> ");
		long num2 = in.nextLong();
		System.out.println(" 연산의 결과 =========== ");
		add(num1, num2);
		sub(num1, num2);
		mul(num1, num2);
		div(num1, num2);
		System.out.print("반지름의 길이를 입력하세요. >>");
		double r = in.nextDouble();
		System.out.println(cal1(r));
		System.out.println(cal2(r));
		
		
//		System.out.println(num1);
//		System.out.println(add(20, 10)); // 프린트 메소드실행 전에 add메소드를 먼저 호출하고 반환값을 출력함
//		System.out.println(sub(20, 10));
//		System.out.println(mul(10, 50));
//		System.out.println(div(10, 3));// 인자를 int형으로 전달해도 대입연산자도 연산이므로 float으로 자동형변환이 발생함 (float이랑 int가 같은 4byte여도 float이 더 크다고 인식)
	}

// num1 num2 중복되는데 매개변수라고 불리는 num1,num2도 지역변수이므로 각각 메소드에 블록안에서만 유효함
	
	//정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의
	static void add(long num1, long num2) {
		System.out.println(num1+ " + " + num2 + " = " + (num1+ num2));
//		return num1 + num2;
	}

	static void sub(long num1, long num2) {
//		return num1 - num2;
		System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
	}

	static void mul(long num1, long num2) {
//		return num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
	}

	static void div(float num1, float num2) { //인자 전달하면 float num1 = 10;이랑 같은뜻
//		return num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
		
	}
	static double cal1(double r) {
		//2 x π x r
		return 2*Math.PI*r;
	}
	static double cal2(double r) {
		return Math.PI*r*r;
	}
}
