package chapter07;

public class SmartPhoneImpl1 extends Phone {
	String model;

	public SmartPhoneImpl1(String phoneNumber, String model) {
		super(phoneNumber);
		this.model = model;
	}
	@Override
	void call() {// 오버라이딩
		super.call();
		System.out.println("이어팟을 이용해서 통화합니다.");
	}

	public static void main(String[] args) {
		SmartPhoneImpl1 phone = new SmartPhoneImpl1("010-0000-0000", "Google");
		phone.call();

	}
}
