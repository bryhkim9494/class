package chapter09;

public class ObjectTest {

	public static void main(String[] args) {

		Car c1 = new Car("2023A001");
		Car c2 = new Car("2023B001");
		Car c3 = c1;
		Car c4 = new Car("2023A001");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println();
		System.out.println(c1.equals(c2)); // 참조값 비교
		System.out.println(c1.equals(c3)); // 참조값 비교
		System.out.println(c1.equals(c4));
		System.out.println(c1.equals(null));
		System.out.println(c1.equals("2023A001"));
	}

}

class Car {

	String carNo;

	public Car(String carNo) {
		super();
		this.carNo = carNo;
	}

	@Override
	public boolean equals(Object obj) {// 어떤 타입이든 가능 why? Object타입이 최상위 타입이니까 어떤 타입이든 object타입을 상속하고있음.
		
		// 전달되는 obj가 null값이 들어오면 비교불가이므로 false를 반환해야하고
		// obj가 Car타입이어야 carNo를 비교 할수 있으므로 obj는 Car타입으로 형변환이 가능해야한다!
		// equals 패턴 기억하면 좋음 ( 오버라이딩해서 사용)
		Car car = null;
		if (obj != null && obj instanceof Car) {
			// obj가 형변환이 가능하다면 형변환을 하고 해당하는 carNo를 비교해서 결과값을 반환하는형태로 처리되어야한다.
			car = (Car) obj;
			/// 문자열을 비교해서 같은지 여부 반환
			if (carNo.equals(car.carNo)) { 
				return true;
			}

		}

		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return carNo + " 차량입니다.";
	}

}
