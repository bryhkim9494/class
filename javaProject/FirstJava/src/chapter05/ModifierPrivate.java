package chapter05;

public class ModifierPrivate {

	private String name;
	private int age;

	public ModifierPrivate(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 은닉된 변수들은 정해진 메소드를 통해서 엑세스 및 설정하게 한다!
	// Getter/Setter
	public String getName() { // Getter
		return this.name;
	}

	public void setName(String name) { // Setter
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	void tell() {

		System.out.println("안녕하세요. " + age + "살 " + name + " 입니다.");
	}

}
