package chapter05.phone;

public class MemberMain {
	public static void main(String[] args) {
		Member member1 = new Member("손흥민","son@gmail.com",20,"010-0000-0000");
		Member member2 = new Member("박지성", "park@gmail.com");
				member1.showData();
				System.out.println();
				member2.showData();
				
	
	}
}
