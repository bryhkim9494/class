package chapter02;

public class Member {
	public static void main(String[] args) {

//		
//		System.out.println();
//		System.out.println();
//		String name = "손흥민";
//		
//		int age = 20;
//		double height = 180.0;
//		boolean hasBook = true;
//		
//		System.out.println("이름 : " + name);
//		System.out.println("나이 : " + age);
//		System.out.println("키 : " + height);
//		System.out.println("책의 보유여부 : " + hasBook);
		
		
		
		// 변수 선언 : 메모리 할당, 저장 , 이름으로 참조
		
		String name;// 변수 선언 (인스턴스변수에서 이렇게 사용, 인스턴스 변수는 자동으로 초기화됨)
		name = "손흥민"; // 초기화
		// 문자열이 단순 저장되는게 아니라 손흥민이라는 문자열은 heap영역에 존재 ///////// name이라는 변수는 stack영역에 주소값을 저장하고있음 -> 이런것이 참조변수이다.
		
		int age = 20; // 변수 선언과 초기화가 동시에 ( 주로 메소드안에서는 동시에 쓰임)
		
		double height = 190.5;
		
		boolean hasBook = false;
		
		System.out.println(" 이름 : " + name);
		System.out.println(" 나이 : " + age);
		System.out.println(" 키 : " + height);
		System.out.println(" 책 보유 여부 : " + hasBook);
		
		
		
		
		
		
		
	}
	
	
}
