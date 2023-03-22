package chapter03;

public class Operator10 {
	public static void main(String[] args) {
		String str1 = "JAVA";
		String str2 = "Program";
		//str1과 str2는 참조변수이다 => 참조변수는 객체를 가리키는 메모리 주소값을 저장함
		//참조변수의 관계연산은 == , != 두개만 이루어진다.
		
		
		System.out.println(str1 == str2); // 참조 주소 값 == 참조 주소 값
		System.out.println(str1 != str2); // 참조 주소 값 != 참조 주소 값
		// System.out.println(str1 > str2); //오류
	}
}
