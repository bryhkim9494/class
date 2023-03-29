package chapter05.phone;

import java.util.Date;

public class MemberMain {
	public static void main(String[] args) {

		Date now = new Date();
		java.sql.Date time = new java.sql.Date(0);
		
		SmartPhone smartPhone = new SmartPhone();

		Member member1 = new Member("손흥민", "son@gmail.com", 20, "010-0000-0000", smartPhone);
		Member member2 = new Member("박지성", "park@gmail.com");
		member1.showData();
		System.out.println();
		member2.showData();
		System.out.println();
		dataPrint(member1); // 매개변수의 인자 => Member 타입의 인스턴스를 가리키는 주소값을 전달해야한다.
		System.out.println();
		dataPrint(member2);
	}

	static void dataPrint(Member member) { // 여기서는 참조형으로 매개변수가 쓰임 -> 전달해줄때 인스턴스 참조 주소값이 전달됨
		// Member member = member1;
		// Member member :매개변수이면서 참조변수이다.
		member.showData();
	}
}
