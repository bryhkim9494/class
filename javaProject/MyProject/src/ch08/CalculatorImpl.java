package ch08;

public class CalculatorImpl implements Calculator {

	@Override
	public long add(long n1, long n2) {
		// TODO Auto-generated method stub
		return n1 + n2;
	}

	@Override
	public long sub(long n1, long n2) {
		// TODO Auto-generated method stub
		return n1 - n2;
	}

	@Override
	public long mul(long n1, long n2) {
		// TODO Auto-generated method stub
		return n1 * n2;
	}

	@Override
	public double div(double n1, double n2) {
		// TODO Auto-generated method stub
		return n1 / n2;
	}

	public static void main(String[] args) {

		Calculator cal = new CalculatorImpl(); 	// 인터페이스 구현 => 다형성
												// 다형성 가능 => 메소드의 매개변수로 선언, 인터페이스 타입의 배열도 가능하다는 뜻이다.
//		Calculator cal = new Calculator(); // 여기서는 인터페이스이니까 이게 "Cannot instantiate the type Calculator" 이라고 나오는것이다.
		System.out.println(cal.add(10, 5));
		System.out.println(cal.sub(15, 10));
		
		

	}

}