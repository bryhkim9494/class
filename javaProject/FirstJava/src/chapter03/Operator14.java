package chapter03;

public class Operator14 {
	public static void main(String[] args) {
		
		short snum1 = 20;
		short snum2 = 30;
		snum1 += snum2;// 복합대입연산을 쓰면 타입을 유지시켜준다.
		//snum1 = snum1 + snum2; // 여기서는 복합대입연산을 사용안해서 int로 바껴서 오류가남
		System.out.println(snum1);
		
		
		
		System.out.println();
		
		int num =10;
		
		num += 5; // num = num + 5; => num = 10 + 5;
		System.out.println(num);
		num -= 5; // num = num - 5; => num = 15 - 5;
		System.out.println(num);
		num *= 2; // num = num * 2; => num = 10 * 2;
		System.out.println(num);
		num /= 2; // num = num / 2; => num = 20 / 2;
		System.out.println(num);
		num %= 3; // num = num % 3; => num = 10 % 3;
		System.out.println(num);
		
		
		
	}
}
