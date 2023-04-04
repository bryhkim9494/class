package api;

public class Person {

	String name;
	String personNumber;

	public Person(String name, String personNumber) {
		super();
		this.name = name;
		this.personNumber = personNumber;
	}

		// 1. 위 Person 클래스의 equals() 메소드를 오버라이딩해서
		// 주민등록번호가 같으면 같은 인스턴스로 판별하는 프로그램을 만들어봅시다.
	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		// 주민등록번호가 같으면 같은 인스턴스로 판별

		// 매개변수로 전달받은 obj를 Person타입으로 형변환한후에(null값이 아닌 상태에세 형변환 하기전에 형변환 여부 체크해야함)
		// personNumber를 비교하고 결과값을 result에 대입.
		if (obj != null && obj instanceof Person) {// null값이 아닌 상태에서 형변환 하기전에 형변환 여부 체크해야함
			Person p = (Person) obj;
			result = this.personNumber.equals(p.personNumber);
		}
		return result;
	}

	public static void main(String[] args) {
		Person p1 = new Person("손흥민", "951214-1000000");// 주민등록번호가 같으면 같은 인스턴스로 판별
		Person p2 = new Person("박지성", "951214-1000000");
		System.out.println(p1.equals(p2));
	}
}
