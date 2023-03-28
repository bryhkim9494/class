package quiz;

public class Contact {
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String events;
	private String groups;

	Contact(String name, String phoneNumber, String email, String address, String events, String groups) {

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.events = events;
		this.groups = groups;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	void print() {
		System.out.println("이름 : " + name + "전화번호 : " + phoneNumber + "이메일 : " + email + "주소 : " + address + "생일 : "
				+ events + "그룹 : " + groups);
	}

	public static void main(String[] args) {
		Contact ct = new Contact("1 ", "1 ", "1 ", "1 ", "1 ", "1 ");

//		ct.setEvents("adad");
//		System.out.println(ct.getEvents());

//		Scanner in = new Scanner(System.in);

		ct.print();

	}

}
