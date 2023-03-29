package chapter06;

public class ArrayTest3 {
	public static void main(String[] args) {
		// 배열의 선언
		int[] scores; // int타입의 배열인스턴스 주소를 가지는 변수이다.

		// 배열의 생성
		scores = new int[10]; // int타입의 요소 10개를 가지는 배열인스턴스 생성

//		for (int i = 0; i < scores.length; i++) {
//
//			System.out.println(scores[i]);
//
//		}
//		System.out.println();
		// 배열 요소의 참조
		// 배열이름[index]
		// index => (0) ~ (개수-1)
		// 요소의개수 => 배열변수.length
		scores[0] = 60;
		scores[1] = 70;
		scores[2] = 65;
		scores[3] = 90;
		scores[4] = 54;
		scores[5] = 78;
		scores[6] = 76;
		scores[7] = 87;
		scores[8] = 54;
		scores[9] = 35;
//		scores[10] = 60;
		ArrayTest3 at = new ArrayTest3();
		at.resultPrint(scores);// int[] arr = scores;
	}

	// 점수를 저장하고있는 배열을 전달받아 총점과 평균값을 출력하는 메소드
	void resultPrint(int[] arr) { // 매개변수로 할때 주로 arr or array라고 임의로쓴다.
											// int[] arr = scores;

		// 전달 받은 배열은 int 타입의 배열이다! size 제약은 없다.
		int sum = 0;
		float avg = 0.0f;// 지역변수는 항상 초기화!
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		avg = (float) sum / arr.length;
		System.out.println("=================================");

		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);

	}

}
