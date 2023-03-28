package chapter05;

public class SingletonMain {
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance(); // 클래스를 가지고 참조변수를 만듬 -> 클래스는 public이니까 에러X
		//s = new Singleton();// private때문에 에러O //외부에서 인스턴스 생성이 불가능
		s.printData();
		
		Singleton s1 =Singleton.getInstance();
		Singleton s2 =Singleton.getInstance();
		
		s1.printData();
		s2.printData();
	}
}
