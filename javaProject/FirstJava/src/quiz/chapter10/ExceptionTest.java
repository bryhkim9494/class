package quiz.chapter10;

import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();

		try {
			for (int i = 0; i < id.length(); i++) {
				char c = id.charAt(i);
//				System.out.println(id.length());
//				System.out.println( id.charAt(i));
				if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')) {
					BadIdInputException e = new BadIdInputException();
					throw e;
				}
			}
		}

		catch (BadIdInputException e) {
			System.out.println("사용자의 입력 값이 올바르지 않습니다.");
		}
	}

//	static boolean checkId(String id) {
//
//		boolean result = true;
//		for (int i = 0; i < id.length(); i++) {
//			char c = id.charAt(i);
//			if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')) {
//				result = false;
//				break;
//			}
//		}
//
//		return result;
//	}
}
