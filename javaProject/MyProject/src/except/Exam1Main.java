package except;

import java.util.Scanner;

public class Exam1Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		Class.forName(null);
		System.out.println("아이디를 입력하세요.");
		String id = sc.nextLine();

		// 정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 => 확인한다는것은 판별한다는것이므로 if를 사용하면된다.
		for (int i = 0; i < id.length(); i++) {
			char c = id.charAt(i);
			if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')) {
				// 사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.
				try {
					 throw new Exception();// 형태 : <throw 인스턴스>
					//throw new BadIdInputException(id);
				} catch (Exception e) {
					System.out.println("입력값은 영문자 소문자/대문자와 숫자만 가능합니다.");
					System.out.println(e.getMessage());
					e.printStackTrace();
					break; // return;

				}

			}

		}

	}
}
