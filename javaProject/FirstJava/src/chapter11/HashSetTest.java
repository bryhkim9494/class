package chapter11;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args) {

		HashSet<String> set = new HashSet<>();
		Object o;
		Integer i;
		set.add("손흥민");
		set.add("박지성");
		set.add("이강인");
		set.add("손흥민");
		set.add("이강인");

		System.out.println("요소의 개수  : " + set.size()); // 요소의 개수는 5개가 아닌 3개다.

		for (String name : set) {

			System.out.println(name); // set에있는 데이터들 출력
		}

		HashSet<Integer> numbers = new HashSet<Integer>();

		numbers.add(10); // Integer타입인데 10을 적을수 있는 이유는 autoboxing되서 적을수 있는것임
		numbers.add(20);
		numbers.add(30);
		numbers.add(10);
		numbers.add(30);
		for (int num : numbers) {
			System.out.println(num);
		}
	}
}
