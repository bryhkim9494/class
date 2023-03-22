package chapter03;

public class Operator09 {

	public static void main(String[] args) {
		int num1=30;
		int num2 =2;
		int age =12;
		// 관계연산의 결과 값은 -> 논리값(true or false)
		System.out.println(num1 ==num2);
		System.out.println(num1 == 30);
		
		
		System.out.println((age > 19));
		System.out.println(age <20);
		System.out.println();
		System.out.println(num1 < num2);
		System.out.println(num1 >= num2);
		System.out.println(num1 <= num2);
		System.out.println();
		System.out.println(num1 != num2);
		System.out.println();
		
		
		if(age >19) {
			// true일때 실행 코드
			System.out.println("참일때 실행되는 구문");
		} else {
			// false일때 실행 코드
			System.out.println("거짓일때 실행되는 구문");
		}
		
	}
}
