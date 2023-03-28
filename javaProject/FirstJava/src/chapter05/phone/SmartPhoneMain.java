package chapter05.phone;

public class SmartPhoneMain {
	public static void main(String[] args) {

		SmartPhone sp1 = new SmartPhone("red", 5.0f, 10);
		// 1. n
		SmartPhone sp2 = new SmartPhone("gold", 5.0f);

		SmartPhone sp3 = new SmartPhone();

//		sp.color = "white";
//		sp.size = 4.5f;
//		sp.volume = 5;
//		System.out.println(sp1.color);
//		System.out.println(sp1.size);
//		System.out.println(sp1.volume);
//		System.out.println();
//		System.out.println(sp2.color);
//		System.out.println(sp2.size);
//		System.out.println(sp2.volume);
//		System.out.println();
//		System.out.println(sp3.color);
//		System.out.println(sp3.size);
//		System.out.println(sp3.volume);

		// 참조변수의 초기값은 null로 초기화가 된다.

		Member member = new Member("king","king@gmail.com",20,"010-0000-0000",sp2);
		printInfo(member);
		
	}

	static void printInfo(Member member) {
		member.showData();
	}
	
	
}
