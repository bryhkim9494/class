package quiz.chepter7;

public class Female extends Person {
	int age;

	public Female(String name, String personID, int age) {
		super(name, personID);
		this.age = age;
	}

	@Override
	void hello() {
		
		super.hello();
		System.out.println(super.name+"\t"+super.personID+"\t"+age);
	}
	public static void main(String[] args) {
		Female female = new Female("박지성", "900101-1234567", 30);
		female.hello();
	}
	
}
