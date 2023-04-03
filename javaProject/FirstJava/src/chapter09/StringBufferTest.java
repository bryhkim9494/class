package chapter09;

public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();// StringBuffer/ StringBuilder을 사용하는 목적 : 문자열을 생성
//		stringbuffer랑 stringbuilder는 같음
		
		
		System.out.println(sb1.capacity());
		StringBuffer sb = new StringBuffer("Hello");
		System.out.println(sb); // sb라고하면 toString반환해줌
		System.out.println(sb.capacity()); // 5 + 16 =21

		// append
		sb.append('~').append(" JAVA"); // "Hello~"
//		sb.append("  JAVA"); //"Hello~  JAVA"

		System.out.println(sb);
		System.out.println("sb1: " + sb1 + "         " + sb);

		// delete

		sb.delete(5, 7); // 5~ (7-1) 까지 지워줌
		System.out.println(sb);

		// insert

		sb.insert(5, '~');
		System.out.println(sb);
		sb.insert(6, "~! ");
		System.out.println(sb);
		sb.insert(sb.length(), false);
		System.out.println(sb);
		// reverse
		sb.reverse();
		System.out.println(sb);
		
		String result = new String(sb);
		System.out.println(result);

	}
}
