package contact;

public class ContactMain {
	public static void main(String[] args) {
		Contact c = new Contact("손흥민", "010-0000-0000", "son@gmail.com", "런던", "1990.01.01", "친구");
		System.out.println("이름 : " + c.getName());// Getter메소드를 사용해서 데이터를가지고옴
		System.out.println("전화번호 : " + c.getPhoneNumber());
		System.out.println("이메일 : " + c.getEmail());
		System.out.println("주소 : " + c.getAddress());
		System.out.println("생일 : " + c.getBirthday());
		System.out.println("그룹 : " + c.getGroups());
		
		System.out.println("------------------------------------");
		c.printData(); //<--생성된 인스턴스의 정보 출력 메소드
		
		//변수를 변경하기위해 Setter메소드 사용
		c.setPhoneNumber("010-9999-9999");
		c.setEmail("son@naver.com");
		c.setAddress("서울");
		c.setBirthday("2000.12.31");
		System.out.println("------------------------------------");
		c.printData();
		
		
		
	}
}
