package quiz;

public class Quiz06 {
	public static void main(String[] args) {
		int num = 1;
		int sum = 0;
		while(num <100 ) {
			sum +=num;
//			System.out.println(sum);
			num++;
		}
		System.out.println("1부터 99까지의 합 : " + sum);
	}
}
