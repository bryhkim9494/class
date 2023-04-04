package quiz.chapter10;

import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		
		if(checkId(id)) {
			System.out.println(id);
		} else {
			System.out.println("영문자와 숫자만 가능합니다.");
		}
		
	}
	static boolean checkId(String id) {
		
		boolean result = true;
		for (int i= 0; i <id.length(); i++ ) {
			char c = id.charAt(i);
			if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c>='0' && c <='9')) {
				result = false;
				break;
			}
		}
		
		return result;
	}
}
