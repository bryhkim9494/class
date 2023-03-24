package chapter01;

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
		add(20, 10);
		sub(20, 10);
		System.out.println(add(20, 10)); // 프린트 메소드실행 전에 add메소드를 먼저 호출하고 반환값을 출력함
		System.out.println(sub(20, 10));
		System.out.println(mul(10, 50));
		System.out.println(div(10, 3));// 인자를 int형으로 전달해도 대입연산자도 연산이므로 float으로 자동형변환이 발생함 (float이랑 int가 같은 4byte여도 float이 더 크다고 인식)
	}

// num1 num2 중복되는데 매개변수라고 불리는 num1,num2도 지역변수이므로 각각 메소드에 블록안에서만 유효함
	static long add(long num1, long num2) {

		return num1 + num2;
	}

	static long sub(long num1, long num2) {
		return num1 - num2;
	}

	static long mul(long num1, long num2) {
		return num1 * num2;
	}

	static float div(float num1, float num2) { //인자 전달하면 float num1 = 10;이랑 같은뜻
		return num1 / num2;
	}
//	void a (int a, int b) {
//		
//	}
}
