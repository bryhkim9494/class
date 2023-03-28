package chapter05.phone;

public class Member {
	// 변수
	String name;
	String email;
	int age;
	String phoneNumber;
	SmartPhone phone;

	public Member(String name, String email, int age, String phoneNumber, SmartPhone phone) {

		this.name = name;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.phone = phone;
	}

	public Member(String name, String email) {

		this.name = name;
		this.email = email;
		this.age = 20;
		this.phoneNumber = "입력데이터가 없습니다.";
		this.phone = new SmartPhone();	// 초기화릃 해줌
										// 안하면 null값이 들어감
	}

	void showData() {

		System.out.println("이름 : " + name);
		System.out.println("이메일 : " + this.email);
		System.out.println("나이 : " + this.age);
		System.out.println("전화번호 " + this.phoneNumber);
		this.phone.call();
	}

}
