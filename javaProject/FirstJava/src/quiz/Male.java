package quiz;

public class Male extends Person {
	String address;

	public Male(String name, String personID, String address) {
		super(name, personID);
		this.address = address;
	}

	@Override
	void hello() {

		super.hello();
		System.out.println(super.name+"\t"+super.personID+"\t"+address);
	}

	public static void main(String[] args) {
		Male male = new Male("손흥민", "901231-1234567", "서울시");	
		
		male.hello();
	}

}
