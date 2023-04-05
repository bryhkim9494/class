package chapter11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(10);
		numbers.add(20);

		// 반복자 : Iterator<E> => Collection<E> 구현하는 객체들의 전체 참조목적으로 사용
		Iterator<Integer> itr = numbers.iterator();

		System.out.println("Iterator를 이용한 전체 참조 ");
		while (itr.hasNext()) {
			// System.out.println(itr.next());
			int num = itr.next();
			System.out.println(100 + num);

		}
		System.out.println("=====================================");

		for (int n : numbers) { // numbers는 참조변수인데 int로 Auto Unboxing발생해서 int기본형 사용가능
								// 참조형은 연산 불가능
			System.out.println(n);
		}

		System.out.println("=====================================");
		// Collection<E> => List<E> => ArrayList<E>

		// String 타입의 객체를 저장(개념상) => String타입의 인스턴스를 참조하는 참조값을 저장(풀어서 말하면,실제로)
		ArrayList<String> list = new ArrayList<String>();

		// 인스턴스 저장 => 요소 저장(=안에있는 데이터) -> add라는 메소드 사용
		list.add("손흥민");
		list.add(new String("박지성"));
		list.add(new String("이강인"));

		// 데이터 참조하는 방법: get();
		System.out.println(list.get(0));
		String name = list.get(1);
		System.out.println(name);
		System.out.println(list.get(2));
		System.out.println("=====================================");

		// 특정 위치(index값 0)의 요소 삽입 ->0 index에 안정환이 들어가서 손 박 이 한칸씩 뒤로밀림.(성능이슈 발생할수 있음)
		list.add(1, "안정환");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println("=====================================");
		// 저장된 요소의 개수 : size();
		System.out.println("저장된 이름의 개수: " + list.size());
		System.out.println("index : 0 ~ " + (list.size() - 1));
		System.out.println("=====================================");
		// 반복문을 이용해서 일괄 처리
		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i) + " : " + list.get(i).charAt(0));
		}

		System.out.println("=====================================");
		for (String playerName : list) { // for each 구문 for-each 형태)for (요소타입 요소타입의변수 : 집합객체 (집합객체는 배열or 컬렉션))

			System.out.println(playerName + " : " + playerName.charAt(2));
		}
		if (list.contains("손흥민")) {
			System.out.println("잘하자~!!!화이팅!!!");
		}

		if (list.contains("안정환")) {
			// 안정환선수는하차
			list.remove("안정환");// 객체로 처리
			list.remove(0); // 인덱스로 처리
		}
		System.out.println("=====================================");
		for (String playerName : list) { // for each 구문 for-each 형태)for (요소타입 요소타입의변수 : 집합객체 (집합객체는 배열or 컬렉션))

			System.out.println(playerName + " : " + playerName.charAt(2));
		}
		System.out.println("=====================================");
		System.out.println(list.isEmpty());
		// 전체 요소 삭제
		list.clear();
		System.out.println(list.size());
		System.out.println(list.isEmpty());

	}

}
