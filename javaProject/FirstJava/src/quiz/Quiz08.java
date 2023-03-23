package quiz;

public class Quiz08 {
	public static void main(String[] args) {
		int num = 1;
		int sum=0;
		while(num <=1000) {
			
//			System.out.println(num);
			num++;
			if ( num%2==0&&num%7==0) {
				System.out.println(num);
				
			}
			sum+=num;
			
		}
		System.out.println(sum);
	}
}
