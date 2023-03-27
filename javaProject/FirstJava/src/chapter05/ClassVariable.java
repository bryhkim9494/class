package chapter05;

public class ClassVariable {
	
	static String name = "KING";
	static int age=10;
	
	void tellName() {
		
		System.out.println("나의 이름은 " + name + "입니다."); // 클래스 변수도 인스턴스 메소드에서는 같은 멤버로 인식함(name만 적어도됨)
		
	}
	
	void tellAge() {
		
		System.out.println("나이는 " + age + "입니다 ");
		
	}
}
