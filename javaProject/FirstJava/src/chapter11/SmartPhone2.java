package chapter11;

import java.util.HashSet;
//import java.util.HashSet;
import java.util.Set;

public class SmartPhone2 implements Comparable<SmartPhone2> {

	private String name;
	private String phoneNumber;

	public SmartPhone2(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
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

	@Override
	public String toString() {
		return "SmartPhone [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		// 010-9876-5432
		return this.phoneNumber.charAt(phoneNumber.length() - 1) % 5; // 나머지 0 1 2 3 4 //int로 char에서 자동형변환됨
	}

	@Override
	public boolean equals(Object obj) {

		boolean result = false; // boolean 초기화를 false로 해놓고 아래 처리부분은 참으로 하는방법

		if (obj != null && obj instanceof SmartPhone2) {
			SmartPhone2 sp = (SmartPhone2) obj;

			result = phoneNumber.equals(sp.getPhoneNumber());

		}
		return result;
	}
	

	@Override
	public int compareTo(SmartPhone2 o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.getName());
	}

	public static void main(String[] args) {
		Set<SmartPhone2> phones = new HashSet<SmartPhone2>();
//		Set<SmartPhone> phones = new HashSet<>(); 생략가능

		phones.add(new SmartPhone2("손흥민", "010-1234-5678"));
		phones.add(new SmartPhone2("박지성", "010-3333-7777"));
		phones.add(new SmartPhone2("이강인", "010-1234-5678"));
		
		for (SmartPhone2 sp :phones) {
			System.out.println(sp);
		}
		

	}

}
