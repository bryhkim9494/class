package quiz.chapter10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("태어난 년도를 입력하세요");
		try {
			int birth = sc.nextInt();
			System.out.println(birth);
		} catch (InputMismatchException e) {
			
			System.out.println("올바른 태어난 년도를 입력하지 않았습니다.");
		}
		
		
	}
}
