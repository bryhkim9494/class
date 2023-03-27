package chapter05.phone;

public class SmartPhone {

	// 인스턴스 변수
	String color;
	float size;
	int volume;

//	SmartPhone() {	// 생성자 :초기화 메소드이고 인스턴스 변수의 초기화 작업을 한다.
//					// 초기화 작업이 없는 경우 생략 가능하다.
//					// 아래와 같은 생성자를 기본 생성자라고 한다. ( default생성자)
//					System.out.println("인스턴스 생성");
//					
//					
//		
//	}

	// 초기화를 위한 생성자 정의

	SmartPhone(String color, float size, int volume) { // 생성자 오버로딩1

		this.color = color; // this를 붙이는 이유는 앞에 color가 인스턴스 변수를 가리키기 만들기 위해서
		this.size = size;
		this.volume = volume;

	}

	SmartPhone(String color, float size) {// 생성자 오버로딩2

		this(color, size, 0); // this(); => 다른 생성자를 호출하는 기능을 가짐. / 여기서 this는

//		this.color = color;
//		this.size = size;
//		this.volume = 0;
	}

	SmartPhone() {// 생성자 오버로딩3
		this("white", 4.5f, 5);

//		color = "white";
//		size = 4.5f;
//		volume = 5;
	}

	void call() {
		System.out.println("전화 걸기!");
	}

	void volumeUp() {

		volume++;

	}

	void volumeDown() {

		volume--;

	}

}
