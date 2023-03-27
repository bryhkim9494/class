package chapter05;

public class ClassMethod {
	int iv = 10; //인스턴스 변수
	static int cv =30;// 클래스 변수
	
	
	void printNumber1() { //인스턴스 메소드
		System.out.println(iv);
		System.out.println(cv);
	}
	static void printNumber2() { // 클래스 메소드
		System.out.println("class Method");
//		printNumber1();
		ClassMethod cm = new ClassMethod();
		System.out.println(cm.iv);
		System.out.println(cv);
		cm.printNumber1();
		
	}
	public static void main(String[] args) {
		ClassMethod.printNumber2();// 클래스 메소드의 호출: 클래스이름.메소드이름();
		printNumber2(); //같은 class 안에있다고 생각해서 ClassMethod생략해도됨
		
	}
	
}
