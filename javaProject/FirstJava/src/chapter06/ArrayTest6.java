package chapter06;

public class ArrayTest6 {
	public static void main(String[] args) {
		int[][] scores = { { 100, 90, 80 }, { 65, 70, 50 }, { 45, 94, 68 }, { 35, 56, 78 } };

		// 행을 표현하는것이 바깥쪽

		for (int i = 0; i < scores.length; i++) { // 행을 반복
			// scores[i] => 반복하면서 각각에 1차원 배열

			// 열의 반복 : 각 1차원 배열의 요소를 출력
			for (int j = 0; j < scores[i].length; j++) {
				System.out.print("numbers[" + i + "][" + j + "]=> " + scores[i][j] + "\t");
			}
			System.out.println();
		}

	}
}
