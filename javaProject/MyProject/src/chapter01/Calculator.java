package chapter01;

public class Calculator {
	
	public static void plus(int a, int b) {
		
		System.out.println(a+b);
	}
	public static void minus(int a, int b) {
		System.out.println(a-b);
	}
	public static void multiple(int a, int b) {
		System.out.println(a * b);
	}
	public static void  divide (int a, int b) {
		System.out.println(a / b );
	}
	
	public static void main(String[] args) {
		plus(3,4);
		minus(4,3);
		multiple(5,4);
		divide(6, 3); 
	}
	
	
}
