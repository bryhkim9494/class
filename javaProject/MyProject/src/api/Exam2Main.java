package api;

public class Exam2Main {
	public static void main(String[] args) {
		// 2. 1~100,000,000까지 더하기하는 연산의
		// 실행 시간을 측정하는 프로그램을 만들어봅시다.
		
		// 시작 시간
		long startTime = System.currentTimeMillis(); // currentTimeMillis()가 1970.01.01 00:00:00 부터 현재시간까지의 ms를 반환해줌
		// 처리
		//?
		long sum=0;
		for(int i =0; i<= 100000000;i++) {
			sum +=i;
			System.out.println(sum);
		}
		System.out.println(sum);
		// 종료 시간
		long endTime = System.currentTimeMillis();
		// 종료시간 - 시작시간
		long result = endTime - startTime;
		
		System.out.println("실행시간 : " + result);
		
	}
}
