package chapter07;

public class SmartPhone2 extends Phone {

	String model;

	public SmartPhone2(String phoneNumber, String model) {
		// 상위클래스에 매개변수가 있는 생성자가 있다면 상위클래스의 멤버를 초기화할 데이터를 받아서 상위클래스의 생성자를 호출해주어야한다!

		// 현재 클래스의 멤버를 초기화한다!

		super(phoneNumber); // 1. 상위클래스의 생성자 호출 (super)

		this.model = model; // 2. 현재 클래스의 인스턴스 변수의 초기화
	}

	void game() {
		call();
		// super.call(); // super 안붙여도됨 -> 멤버니까
		System.out.println(model + " 게임을 합니다.");
	}

	public static void main(String[] args) {
		SmartPhone2 smartPhone = new SmartPhone2("010-0000-0000", "Google");

		smartPhone.game();
	}
}
