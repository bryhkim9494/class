package chapter07;

public class SmartPhoneImpl2 extends Phone {
	String model;

	public SmartPhoneImpl2(String phoneNumber, String model) {
		super(phoneNumber);
		this.model = model;
	}

	@Override
	void call() {// 오버라이딩
		super.call();
		System.out.println(model + " 이어팟을 이용해서 통화합니다."); //
	}

	void playMusic() { // 추가된 기능.

		System.out.println("음악을 듣습니다.");
	}

	public static void main(String[] args) {
		// 다형성 : 상위타입의 참조변수에 다양한 하위타입의 인스턴스를 참조할 수 있는 것.

		Phone p = new SmartPhoneImpl2("010-9999-9999", "IOS");
		p.call(); // call은 오버라이딩 되있는 상태여서 하위타입에 정의 되어있는 11번째줄이 실행됨.
					// 하위 타입 인스턴스에 정의되어있는 오버라이딩된 call()메소드가 호출된다!
//		p.playMusic();
//		SmartPhoneImpl2 p2 = new SmartPhoneImpl2("000", "test");
//				p2.playMusic();

		SmartPhoneImpl2 p2 = (SmartPhoneImpl2) p;
		p2.playMusic();

	}
}
