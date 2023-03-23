package chapter01;

public class Calculator {
	
	public static void plus(int a, int b) {
		
		System.out.println("더하기 : "+ (a+b));
	}
	public static void minus(int a, int b) {
		System.out.println("빼기 : "+ (a-b));
	}
	public static void multiple(int a, int b) {
		System.out.println("곱하기 : "+ a * b);
	}
	public static void  divide (int a, int b) {
		System.out.println("나누기 : " + a / b );
	}
	
	public static void main(String[] args) {
		plus(3,4);
		minus(4,3);
		multiple(5,4);
		divide(6, 3); 
	}
	
	
}
