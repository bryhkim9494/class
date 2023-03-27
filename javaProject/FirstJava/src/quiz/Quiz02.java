package quiz;

public class Quiz02 {
	public static void main(String[] args) {
		int num = -1;

		// else가 나오면서 범위가 한정되서 하나만 적어도됨.
		if (num < 0) {
			System.out.println("0미만 출력");
		} else if (num < 100) { // else를 통해 확인해보니까 else if조건문에 num >=0을 따로 안적어도 자동적으로 0이상부터시작해서 n<100만 적어도됨 (num
								// >=0 && num <100이렇게 적어도되긴하는데)
			System.out.println("0이상 100미만 입니다.");
		} else if (num < 200) { // num >=100을 가지고 시작함. (num >=100 && num <200)이라고 적어도 틀린건아님.
			System.out.println("100이상 200 미만");
		} else if (num < 300) {
			System.out.println("200이상 300 미만");
		} else {
			System.out.println("300이상");
		}

	}
}