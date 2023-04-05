package chapter08.phone;

public class SmartPhone implements Phone{

	boolean power;// 최초 초기값 false
	
	
	
	public SmartPhone() {
		super();
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		String number1 = String.valueOf(PHONE_NUM_1); // String.valueof 잘 쓰임
		String number2 = String.valueOf(PHONE_NUM_1);
		String number3 = String.valueOf(PHONE_NUM_9);
	System.out.println(number1+number2+number3+"에 전화를 합니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("전원을 켭니다.");
		if(!power) { // 
			power = true;
		}
		
		
	}

	@Override
	public void turnOff() {
		
		System.out.println("전원을 끕니다.");
		if(power) { // 전원이 켜있으면 끈다
			
			
			power = false;
			
		}
	}

	
}
