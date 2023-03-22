package chapter03;

public class Operator13 {
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		boolean result =false;
		result = (num1 += 10)<0 && (num2 += 10) > 0; // num1 += 10 ->num1 = num1 + 10
		System.out.println(result);
		System.out.println("num1 : " + num1 + " , num2 : " + num2); // SCE 발생 ->num1만 실행하고 num2는 실행x
		
		result = (num1 +=10)>0 || (num2 +=10) > 0;
		System.out.println(result);
		System.out.println("num1 : " + num1 + " , num2 : " + num2);// SCE 발생 ->num1만 실행하고 num2는 실행x
		
	}
}
