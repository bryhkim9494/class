package test;


public class FirstJava {
	
//	static int add(int num1, int num2) {
//		int result;
//		result = num1 + num2;
//		return result;//결과 값 반환
//	}
	
	/*
	 * 클래스는 객체를 만드는틀
	 * 클래스를 가지고 객체 생성
	 * 클래스이름 대문자 시작(FirstJava),메소드 이름은 소문자 시작(main)
	 */

	
	//식별자 : 클래스이름, 메소드이름,변수 이름
	
	
	//자바에서는 프로그램을 하기 위해서는 무조건 클래스가 있어야함.
	
	
	
	
	/*
	 * 주석은 컴파일시 코드로 인식하지 않는다. 
	 * 주석: 어떤 파일, 어떤 목적, 누가 작성, 언제 수정
	 */
	
	
	/*
	 * 클래스안에서 변수들 정의, 함수(메소드)들 정의
	 */
	
	
	
	// 메인 메소드 -> 클래스 실행시 시작 시점 : public static void main(String[] args)
	
	
	
	public static void main(String[] args) {
	
//		System.out.println("First JAVA1");
//		System.out.println("First JAVA2");
//		System.out.println("First JAVA3");
//		
//		System.out.println("First JAVA4");
		// 변수 : 메모리 공간 할당, 메모리 주소 역할
		// 변수의 선언 방법 : 자료형타입 변수이름;
		
		// 나이를 저장하는(목적) 변수를 선언		
		int age; //--> 변수선언 : 나이 값을 저장 할 수 있는 변수 선언
		age =20 ;//--> 변수의 초기화: 변수 선언후 값을 처음 대입하는것.
		
		// 원주율 pi - > 3.141592.....(실수)
		double pi;
		pi = 3.141592;
		System.out.println(pi);
		
		System.out.println(age);
//		System.out.println();
//		System.out.println();
		int resultValue = add(10,20);
		System.out.println(resultValue);
		
		hello();
		hello2("손흥민");
		// TODO Auto-generated method stub

		
	}
	
	
	// 정수를 두개받아 -> 매개변수 선언
	// 더하기 연산한 -> 내부처리
	// 결과를 반환하는 메소드 -> return 결과값;
	
	static int add(int num1, int num2) {
		int result;
		result = num1 + num2;
		return result; // 결과 값 반환
	}
	
	
	// 기능 : 인삿말을 출력하는 기능을 가지는 메소드
	// 매개변수 : 데이터 받는 정의 --> 여기서는 데이터 필요 없다!
	// 결과 반환 : 반환이 없다!
	// 반환타입 메소드이름(매개변수) {}
	// void : 반환 값이 없을때 사용 -> return 이 없다.
	
	static void hello() {
		System.out.println("안녕하세요!");
		System.out.println("반갑습니다.");
	}
	
	// 이름을 전달 받아 이름과 인사말을 출력하는 메소드
	// 매개변수 : 이름(문자열)
	// 반환 : 없다!
	
	static void hello2(String name) {
		System.out.println(name);
		System.out.println("안녕하세요");
	}
	

}





















