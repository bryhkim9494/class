package chapter11;

import java.util.HashMap;
import java.util.Set;

public class SmartPhoneHashMapTest {

	public static void main(String[] args) {
		HashMap<String, SmartPhone> hashMap = new HashMap<>();

		SmartPhone p = new SmartPhone("Spring", "010-1111-2222");

		hashMap.put("ver", p);
//		hashMap.put(p.getPhoneNumber(), p); //p.getPhoneNumber() 중복X , 
		SmartPhone p2 = new SmartPhone("SON", "010-1111-2222");
		hashMap.put("programName", p2);
//		p = new SmartPhone("son", "010-1111-2222");
//		hashMap.put(p.getPhoneNumber(), p);

//		System.out.println(hashMap.get("010-1111-2222"));
//		System.out.println(hashMap.get("010-2222-0000"));
//		System.out.println(hashMap.get("010-2222-0000").getPhoneNumber()); //nullpointerexception발생함 null값이여서

		System.out.println(hashMap.get("ver"));
		System.out.println(hashMap.get("programName"));

		System.out.println("===============================================");
		Set<String> keySet = hashMap.keySet();//컬렉션 생성
		for(String keyName : keySet ) {
			System.out.println(keyName + " : " + hashMap.get(keyName));
		}
	}
}
