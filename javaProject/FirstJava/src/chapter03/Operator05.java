package chapter03;

public class Operator05 {
	public static void main(String[] args) {
		int num1 = 30;
		System.out.println(num1++);
		System.out.println(++num1);
		System.out.println(num1--);
		System.out.println(--num1); // (num1->31) -> 31출력
		System.out.println(num1++ + ++num1); // 30 + 32+
	}
}
