package chapter07;

public class ClassCasting2 {
	public static void main(String[] args) {
		AndroidPhone androidPhone = new AndroidPhone("010-0000-0000");
		IPhone iPhone = new IPhone("010-1111-1111");
		callByPhone(androidPhone);
		callByPhone(iPhone);
	}
	// 매개변수에 다형성을 적용 => 추가적인 메소드 생성이 필요없어진다!
	public static void callByPhone(Phone p ) {// 오버라이딩해서 Phone클래스에있는 call메소드가아닌 AndroidPhone클래스에 있는 call메소드가 실행됨 IPhone클래스도 마찬가지
		p.call();
	}
//	public static void callByPhone(AndroidPhone p ) {
//		p.call();
//		
//	}
//	public static void callByPhone(IPhone p ) {
//		p.call();
//		
//	}
}
