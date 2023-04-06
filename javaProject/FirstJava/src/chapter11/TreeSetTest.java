package chapter11;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		
		TreeSet<SmartPhone2> phones = new TreeSet<>();
		
//		TreeSet<Integer> numbers = new TreeSet<>();
		phones.add(new SmartPhone2("Spring", "010-9999-9999"));
		phones.add(new SmartPhone2("King", "010-0000-0000"));
		phones.add(new SmartPhone2("Adam", "010-1111-1111"));
		phones.add(new SmartPhone2("Scott", "010-3333-3333"));
		phones.add(new SmartPhone2("Smith", "010-7777-7777"));

		
		for( SmartPhone2 sp : phones) {
			
			System.out.println(sp);
		}
		
	}
}
