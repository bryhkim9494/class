package chapter08;

public class SmartPhone extends Phone {

	String model;

	public SmartPhone(String phoneNumber, String model) {
		super(phoneNumber);
		this.model = model;

	}

	@Override
	void turnOn() {
		System.out.println(model + "모델에 맞게 전원을 켰습니다.");
	}

	public static void main(String[] args) {

//		Phone phone = new Phone(); // 추상클래스여서 안됨

		Phone smartphone = new SmartPhone("010-0000-0000", "IOS"); //Phone이라는 상위타입으로 접근
		smartphone.turnOn();
	}

}
