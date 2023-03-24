package chapter04.exam;

public class Exam07 {
	public static void main(String[] args) {
		// 1~100까지 출력
		int cnt = 1;
		while (cnt <= 100) {
			System.out.println(cnt++);

//			cnt++;// 후위연산자는 먼저 출력하고 증가시킨다.
		}
			System.out.println("------------------------------");
			System.out.println("cnt값 : " +cnt);//101
			System.out.println();
		do {
			cnt--;
			System.out.println(cnt);
//			System.out.println(--cnt);
		} while (cnt > 1);
	}
}
