package chapter10;

public class ExceptionTest {
	
	public static void main(String[] args) {
		try {
			Class.forName("Example"); // forName메소드 사용할때 꼭 예외처리를 해줘야함 왜냐하면 throws 키워드가 있어서
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾지 못했습니다.");
		}

		System.out.println();
		int[] numbers = { 1, 2, 3, 4, 5 };
		try {
			System.out.println(numbers[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("사용가능한 index범위를 벗어났습니다.");
			System.out.println();
			e.printStackTrace();

		}
		System.out.println();

		try {
			numbers = new int[-10];
		} catch (NegativeArraySizeException e) {
			System.out.println("배열 생성시에는 배열의 사이즈에는 음수입력이 불가능합니다.");
		}
		System.out.println();
		String str = null;
		try {
			str.trim();
		} catch (NullPointerException e) {
			System.out.println("참조값은 null 이면 안됩니다.");
		}

	}
}
