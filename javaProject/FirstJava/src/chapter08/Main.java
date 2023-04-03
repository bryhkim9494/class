package chapter08;

public class Main {
	public static void main(String[] args) {
//		AbstractClass abstractClass; // 참조변수 선언과정 까지는 가능함 , 언제나 상위타입->다형성 가능
//		abstractClass = new AbstractClass(); // 인스턴스 생성과정/// 추상클래스여서 인스턴스 생성 불가

		
		AbstractClass abstractClass = new AbstractClass() {
			
			@Override
			void abstractMethod() {
				// TODO Auto-generated method stub
				
			}
		};
		NewClass class1 = new NewClass();
		class1.abstractMethod();

		class1.instanceMethod();
		System.out.println();
		class1.printData();
	}
}
